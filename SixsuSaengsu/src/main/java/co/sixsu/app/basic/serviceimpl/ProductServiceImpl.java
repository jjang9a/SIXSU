package co.sixsu.app.basic.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.sixsu.app.basic.domain.ReceiveVO;
import co.sixsu.app.basic.mapper.ProductMapper;
import co.sixsu.app.basic.service.ProductService;
import co.sixsu.app.quality.domain.QilVO;
import co.sixsu.app.work.domain.PfmcVO;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{

	@Autowired ProductMapper mapper;
	
	// 반제품 입고 관리
	
	@Override // 반제품 입고대기 리스트
	public List<ReceiveVO> readySpList() {
		List<ReceiveVO> list = mapper.readySpList();
		return list;
	}
	
	@Override // 반제품 입고 목록
	public List<ReceiveVO> spRecList() {
		return mapper.spRecList();
	}

	@Override
	@Transactional // 반제품 LOT부여 및 입고
	public List<ReceiveVO> spRec(List<ReceiveVO> list) {
		// 여러제품을 한번에 입고하기 위해 index를 구분하는 과정
		List<Integer> check = new ArrayList<>();
		check.add(0);
		String item = list.get(0).getSpId();
		for(int i=0; i<list.size(); i++) {
			if(!list.get(i).getSpId().equals(item)) {
				check.add(i); // 상품의 종류가 달라지는 시점마다 배열에 넣기
				item = list.get(i).getSpId();
			}
		}	
		// 제품별로 LOT부여 및 입고 하는 과정
		int i = 0; // check의 인덱스로 쓰일 변수 i 정의
		while(i < check.size()) {
			String sp = list.get(check.get(i)).getSpId(); // 반제품 코드
			int lot = list.get(check.get(i)).getSpLot(); // 반제품 LOT 규격
			int last = 0; // for문의 끝을 담을 변수 선언
			if(i == check.size()-1) {
				last = list.size();
			}else {
				last = check.get(i+1);
			}
			for(int j=check.get(i); j<last; j++) {
				ReceiveVO vo = list.get(j); // 이번에 처리해야 할 생산완료건
				ReceiveVO lotInfo = new ReceiveVO();
				lotInfo.setSpId(sp);
				mapper.procSpLotInfo(lotInfo); // 마지막 LOT번호
				int ableQt = lot-(lotInfo.getSpQt()); // LOT에 더 들어갈 수 있는 수량
				int qt = vo.getGoodQt();
				if(ableQt == lot) { // 적재수량이 LOT규격과 같다 = 새 LOT생성
					spRecLarge(lot, ableQt, qt, lotInfo, vo);
				} else { // 미적재된 LOT가 존재 할 때
					if(qt <= ableQt) {
						if(qt == ableQt) { // 현재수량이 적재가능수량과 같다면
							vo.setSpLotQtCk("Y"); // 적재완료
						}else { // 현재수량이 적재가능수량보다 적다면
							vo.setSpLotQtCk("N"); // 적재량 미달				
						}
						vo.setSpQt(lotInfo.getSpQt() + qt); // LOT수량을 원래수량 + 현재 수량으로 세팅
						vo.setSpLotId(lotInfo.getSpLotId()); // 마지막 LOT번호를 LOT번호로 세팅
						mapper.updateSpLot(vo); // LOT번호 부여
						vo.setSpRecQt(qt); // 입고수량을 현재수량으로 설정
						mapper.insertSpRec(vo); // 입고
						System.out.println("중간점검 : " + list);
					} else if(qt > ableQt) {
						vo.setSpLotQtCk("Y"); // 적재완료
						vo.setSpQt(lot); // LOT수량을 최대수량으로 설정
						vo.setSpLotId(lotInfo.getSpLotId()); // 마지막 LOT번호를 LOT번호로 세팅
						mapper.updateSpLot(vo); // LOT번호 부여
						vo.setSpRecQt(ableQt); // 입고수량을 LOT남은 수량으로
						mapper.insertSpRec(vo); // 입고
						qt -= ableQt;
						spRecLarge(lot, ableQt, qt, lotInfo, vo); // 적재수량이 LOT규격과 같아졌으므로 Large함수 실행
					}
				}
			}
			i++;
			System.out.println("현재 check 인덱스 : " + i);
		}
		return list;
	}
	
	public void spRecMini(int ableQt, int qt, ReceiveVO lotInfo, ReceiveVO vo) {
		if(qt == ableQt) { // 현재수량이 적재가능수량과 같다면
			vo.setSpLotQtCk("Y"); // 적재완료
		}else { // 현재수량이 적재가능수량보다 적다면
			vo.setSpLotQtCk("N"); // 적재량 미달				
		}
		vo.setSpQt(qt); // LOT수량을 현재 수량으로 세팅
		vo.setSpLotId(mapper.getSpLotId(vo.getSpId())); // 새로운 LOT번호 생성
		mapper.insertSpLot(vo); // LOT번호 부여
		vo.setSpRecQt(qt); // 입고수량을 현재수량으로 설정
		mapper.insertSpRec(vo); // 입고
		qt = 0;
	}
	
	public void spRecLarge(int lot, int ableQt, int qt, ReceiveVO lotInfo, ReceiveVO vo) {
		if(qt <= ableQt) {
			spRecMini(ableQt, qt, lotInfo, vo);
		}else {
			while(qt > lot) {
				System.out.println("남은수량 : "+ qt);
				vo.setSpLotQtCk("Y"); // 적재완료
				vo.setSpQt(lot); // LOT수량을 현재 수량으로 세팅
				vo.setSpLotId(mapper.getSpLotId(vo.getSpId())); // 새로운 LOT번호 생성
				mapper.insertSpLot(vo); // LOT번호 부여
				vo.setSpRecQt(lot); // 입고수량을 현재수량으로 설정
				mapper.insertSpRec(vo); // 입고
				qt -= lot;
			}
			// while문 종료 후 = 현재수량이 lot적재단위보다 적거나 같아 진 경우(위와 같음)
			spRecMini(ableQt, qt, lotInfo, vo);
		}
	}

	
	// 완제품 입고 관리
	
	@Override
	public List<ReceiveVO> readyCpList() {
		return mapper.readyCpList();
	}

	@Override
	public List<ReceiveVO> cpRecList() {
		return mapper.cpRecList();
	}

	@Override
	@Transactional // 완제품 LOT부여 및 입고
	public List<ReceiveVO> cpRec(List<ReceiveVO> list) {
		// 여러제품을 한번에 입고하기 위해 index를 구분하는 과정
		List<Integer> check = new ArrayList<>();
		check.add(0);
		String item = list.get(0).getCpId();
		for(int i=0; i<list.size(); i++) {
			if(!list.get(i).getCpId().equals(item)) {
				check.add(i); // 상품의 종류가 달라지는 시점마다 배열에 넣기
				item = list.get(i).getCpId();
			}
		}	
		// 제품별로 LOT부여 및 입고 하는 과정
		int i = 0; // check의 인덱스로 쓰일 변수 i 정의
		while(i < check.size()) {
			String cp = list.get(check.get(i)).getCpId(); // 완제품 코드
			int lot = list.get(check.get(i)).getCpLot(); // 완제품 LOT 규격
			int last = 0; // for문의 끝을 담을 변수 선언
			if(i == check.size()-1) {
				last = list.size();
			}else {
				last = check.get(i+1);
			}
			for(int j=check.get(i); j<last; j++) {
				ReceiveVO vo = list.get(j); // 이번에 처리해야 할 생산완료건
				ReceiveVO lotInfo = new ReceiveVO();
				lotInfo.setCpId(cp);
				mapper.procCpLotInfo(lotInfo); // 마지막 LOT번호
				int ableQt = lot-(lotInfo.getCpLotQt()); // LOT에 더 들어갈 수 있는 수량
				int qt = vo.getGoodQt();
				if(ableQt == lot) { // 적재수량이 LOT규격과 같다 = 새 LOT생성
					cpRecLarge(lot, ableQt, qt, lotInfo, vo);
				} else { // 미적재된 LOT가 존재 할 때
					if(qt <= ableQt) {
						if(qt == ableQt) { // 현재수량이 적재가능수량과 같다면
							vo.setCpLotQtCk("LOT_Y"); // 적재완료
						}else { // 현재수량이 적재가능수량보다 적다면
							vo.setCpLotQtCk("LOT_N"); // 적재량 미달				
						}
						vo.setCpLotQt(lotInfo.getCpLotQt() + qt); // LOT수량을 원래수량 + 현재 수량으로 세팅
						vo.setCpLotId(lotInfo.getCpLotId()); // 마지막 LOT번호를 LOT번호로 세팅
						mapper.updateCpLot(vo); // LOT 수량 업데이트
						vo.setCpRecQt(qt); // 입고수량을 현재수량으로 설정
						mapper.insertCpRec(vo); // 입고
						System.out.println("중간점검 : " + list);
					} else if(qt > ableQt) {
						vo.setCpLotQtCk("LOT_Y"); // 적재완료
						vo.setCpLotQt(lot); // LOT수량을 최대수량으로 설정
						vo.setCpLotId(lotInfo.getCpLotId()); // 마지막 LOT번호를 LOT번호로 세팅
						mapper.updateCpLot(vo); // LOT 수량, 상태 업데이트
						vo.setCpRecQt(ableQt); // 입고수량을 LOT남은 수량으로
						mapper.insertCpRec(vo); // 입고
						qt -= ableQt;
						cpRecLarge(lot, ableQt, qt, lotInfo, vo); // 적재수량이 LOT규격과 같아졌으므로 Large함수 실행
					}
				}
			}
			i++;
			System.out.println("현재 check 인덱스 : " + i);
		}
		return list;
	}
	
	public void cpRecMini(int ableQt, int qt, ReceiveVO lotInfo, ReceiveVO vo) {
		if(qt == ableQt) { // 현재수량이 적재가능수량과 같다면
			vo.setCpLotQtCk("LOT_Y"); // 적재완료
		}else { // 현재수량이 적재가능수량보다 적다면
			vo.setCpLotQtCk("LOT_N"); // 적재량 미달				
		}
		vo.setCpLotQt(qt); // LOT수량을 현재 수량으로 세팅
		vo.setCpLotId(mapper.getCpLotId(vo.getCpId())); // 새로운 LOT번호 생성
		mapper.insertCpLot(vo); // LOT번호 부여
		vo.setCpRecQt(qt); // 입고수량을 현재수량으로 설정
		mapper.insertCpRec(vo); // 입고
		qt = 0;
	}
	
	public void cpRecLarge(int lot, int ableQt, int qt, ReceiveVO lotInfo, ReceiveVO vo) {
		if(qt <= ableQt) {
			cpRecMini(ableQt, qt, lotInfo, vo);
		}else {
			while(qt > lot) {
				vo.setCpLotQtCk("LOT_Y"); // 적재완료
				vo.setCpLotQt(lot); // LOT수량을 최대 수량으로 세팅
				vo.setCpLotId(mapper.getCpLotId(vo.getCpId())); // 새로운 LOT번호 생성
				mapper.insertCpLot(vo); // LOT번호 부여
				vo.setCpRecQt(lot); // 입고수량을 최대 LOT수량으로 설정
				mapper.insertCpRec(vo); // 입고
				qt -= lot;
			}
			// while문 종료 후 = 현재수량이 lot적재단위보다 적거나 같아 진 경우(위와 같음)
			cpRecMini(ableQt, qt, lotInfo, vo);
		}
	}

	
	// 공정실적 조회
	
	@Override // 공정실적 리스트
	public List<PfmcVO> performanceList() {
		return mapper.performanceList();
	}

	@Override // 공정실적 검색
	public List<PfmcVO> searchPerformance(PfmcVO vo) {
		return mapper.searchPerformance(vo);
	}

	
	// 품질검사 항목 조회
	
	@Override // 품질검사 항목 목록
	public List<QilVO> getInspList() {
		return mapper.getInspList();
	}

	@Override
	public boolean addInsp(QilVO vo) {
		return mapper.addInsp(vo) == 1;
	}

	@Override
	public boolean updateInsp(QilVO vo) {
		return mapper.updateInsp(vo) == 1;
	}

	
	// 반제품 입고 조회
	
	@Override
	public List<ReceiveVO> spRecSearch(ReceiveVO vo) {
		return mapper.spRecSearch(vo);
	}

	
	
}
