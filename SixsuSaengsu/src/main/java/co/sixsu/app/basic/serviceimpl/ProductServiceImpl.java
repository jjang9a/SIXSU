package co.sixsu.app.basic.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.sixsu.app.basic.domain.ReceiveVO;
import co.sixsu.app.basic.mapper.ProductMapper;
import co.sixsu.app.basic.service.ProductService;

@Service("ProductService")
public class ProductServiceImpl implements ProductService{

	@Autowired ProductMapper mapper;
	
	@Override // 반제품 입고대기 리스트
	public List<ReceiveVO> readySpList() {
		System.out.println("서비스 진입");
		List<ReceiveVO> list = mapper.readySpList();
		System.out.println("서비스 : "+list);
		return list;
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
						vo.setEmpId("test"); // 입고담당자 입력
						mapper.insertSpRec(vo); // 입고
						System.out.println("중간점검 : " + list);
					} else if(qt > ableQt) {
						vo.setSpLotQtCk("Y"); // 적재완료
						vo.setSpQt(lot); // LOT수량을 최대수량으로 설정
						vo.setSpLotId(mapper.getSpLotId(sp)); // 마지막 LOT번호를 LOT번호로 세팅
						mapper.updateSpLot(vo); // LOT번호 부여
						vo.setSpRecQt(ableQt); // 입고수량을 LOT남은 수량으로
						vo.setEmpId("test"); // 입고담당자 입력
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
		vo.setSpLotId(lotInfo.getSpLotId()); // 마지막 LOT번호를 LOT번호로 세팅
		mapper.insertSpLot(vo); // LOT번호 부여
		vo.setSpRecQt(qt); // 입고수량을 현재수량으로 설정
		vo.setEmpId("test"); // 입고담당자 입력
		mapper.insertSpRec(vo); // 입고
		qt = 0;
	}
	
	public void spRecLarge(int lot, int ableQt, int qt, ReceiveVO lotInfo, ReceiveVO vo) {
		if(qt <= ableQt) {
			spRecMini(ableQt, qt, lotInfo, vo);
		}else {
			while(qt > lot) {
				vo.setSpLotQtCk("Y"); // 적재완료
				vo.setSpQt(lot); // LOT수량을 현재 수량으로 세팅
				vo.setSpLotId(mapper.getSpLotId(vo.getSpId())); // 마지막 LOT번호를 LOT번호로 세팅
				mapper.insertSpLot(vo); // LOT번호 부여
				vo.setSpRecQt(lot); // 입고수량을 현재수량으로 설정
				vo.setEmpId("test"); // 입고담당자 입력
				mapper.insertSpRec(vo); // 입고
				qt -= lot;
			}
			// while문 종료 후 = 현재수량이 lot적재단위보다 적거나 같아 진 경우(위와 같음)
			spRecMini(ableQt, qt, lotInfo, vo);
		}
	}

	
}
