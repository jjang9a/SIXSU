package co.sixsu.app.quality.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.quality.domain.PrdInspVO;
import co.sixsu.app.quality.domain.QuaVO;
import co.sixsu.app.quality.domain.ReturnInspVO;
import co.sixsu.app.quality.domain.ShipInspVO;
import co.sixsu.app.quality.mapper.QualityMapper;
import co.sixsu.app.quality.service.QualityService;
import co.sixsu.app.work.domain.DetaWorkOrdrVO;

@Service("QualityService")
public class QualityServiceImpl implements QualityService {
	@Autowired
	QualityMapper quaMapper;

	

	// 입고 검사 등록 시 자재 발주 상태 업데이트
	@Override
	public boolean mrUpdate(List<MatreqVO> mlist) {
		int count = 0; // insert 발생 횟수
		for (int i = 0; i < mlist.size(); i++) {

			count += quaMapper.mrUpdate(mlist.get(i));

		}
		return count >= 1;
	}



	// 자재 입고 검사 관련
	@Override
	public List<QuaVO> proRecList() {
		return quaMapper.proRecList();
	}

	// 자재 입고 검사 등록
	@Override
	public boolean insertPr(List<QuaVO> qlist) {
		int count = 0; // insert 발생 횟수
		for (int i = 0; i < qlist.size(); i++) {

			count += quaMapper.insertPr(qlist.get(i));

		}
		return count >= 1;
	}

	// 자재 입고 검사 리스트
	@Override
	public List<QuaVO> prInspList() {
		return quaMapper.prInspList();
	}


	// 입고 검사 등록 프로시저 사용
	@Override
	@Transactional
	public int insertpro(List<QuaVO> list) {
		int count = 0;

		for (int i = 0; i < list.size(); i++) {
			// String num = quaMapper.psInspNum();
			// System.out.println("검사번호:"+num);
			// list.get(i).setInspNum(num);

			QuaVO curData = list.get(i);

			System.out.println("검사번호 포함된 vo:" + curData);

			quaMapper.insertPro(curData);
			System.out.println("insertPor:" + curData);
			if (curData.getInspNum() != null)
				count++;
		}

		return count;
	}


	// 검사 항목 가져오기
	@Override
	public List<QuaVO> inspItem(String matId) {
		return quaMapper.inspItem(matId);
	}

	// 자재 입고 검사 결과 등록(삭제 예정)
	@Override
	public List<QuaVO> insertPri(List<QuaVO> list) {

		System.out.println("서비스");
		int count = 0; // insert 발생 횟수

		for (int i = 0; i < list.size(); i++) {
			QuaVO qua = list.get(i);
			String detNum = qua.getInspNum(); // 세부 지시 검사번호
			String un = "-";

			detNum += -i;
			qua.setDetInspNum(detNum);
			System.out.println(detNum);

			if (qua.getResVal() == null) {
				qua.setResVal(un);
			}
			;

			count += quaMapper.insertQuaDet(list.get(i));
			System.out.println(count);

		}

		return list;
	}

	// 자재 입고 검사 결과 등록 시 업데이트(qua_com업데이트), mat_req 업데이트
	@Override
	@Transactional
	public boolean priRegUpdate(QuaVO qua) {
		int count = 0; // update 발생 횟수
		System.out.println("qua_com 업데이트 vo" + qua);
		count = quaMapper.qComUpdate(qua);

		// 발주 상태 변경
		qua.setMatReqStat("C");
		quaMapper.mUpdate(qua);
		return count >= 1;
	}

	// 검사 세부 insert
	@Override
	@Transactional
	public int insertQuaDet(List<QuaVO> list) {
		System.out.println("서비스");
		int count = 0; // insert 발생 횟수
		
		for (int i = 0; i < list.size(); i++) {
			QuaVO qua = list.get(i);
			String inspNum = qua.getInspNum(); // 세부 지시 검사번호
			String detNum = inspNum + "-" + String.format("%03d", i + 1); // inspNum-001 형식으로 설정

			qua.setDetInspNum(detNum);
			System.out.println(detNum);

			count += quaMapper.insertQuaDet(qua);
		}
		

		System.out.println(count);

		return count;
	}


	// 입고 검사 완료 리스트
	@Override
	public List<QuaVO> afterReqList() {
		return quaMapper.afterReqList();
	}

	// 입고 검사 완료건 단건 삭제
	@Override
	public boolean delInsp(QuaVO qua) {
		QuaVO vo = new QuaVO();
		String reqId = qua.getMatReqId();
		vo.setMatReqStat("A");
		vo.setMatReqId(reqId);
		System.out.println("vo확인"+vo);
		quaMapper.mUpdate(vo);
		return quaMapper.delInsp(qua) >= 1;
	}
	


	// 수정시 검사 항목 리스트
	@Override
	public List<QuaVO> modInspItem(String inspNum) {
		return quaMapper.modInspItem(inspNum);
	}

	// 공정 검사 전 리스트 출력
	@Override
	public List<PrdInspVO> bpAddList() {
		return quaMapper.bpAddList();
	}

	// 공정 검사 등록
	@Transactional
	@Override
	public int bpdAdd(List<PrdInspVO> list) {

		System.out.println("서비스");
		int count = 0; // insert 발생 횟수
		String inspNum = ""; // 검사번호 부여 변수

		for (int i = 0; i < list.size(); i++) {
			PrdInspVO prd = list.get(i);
			inspNum = quaMapper.pdInspNum();
			prd.setInspNum(inspNum);

			System.out.println("bpdAdd: " + prd); // 디버깅 출력

			quaMapper.bpdAdd(prd);

			if (prd.getInspNum() != null)
				count++;
		}

		return count;
	}

	// 제품 품질 관리 검사 대기 리스트
	@Override
	public List<PrdInspVO> prwList() {
		return quaMapper.prwList();
	}
	
	
	// 공정 검사 결과 등록 시 업데이트(qua_com업데이트)
	@Override
	@Transactional
	public boolean prdComUpdate(PrdInspVO prd) {
		int count = 0; // update 발생 횟수
		System.out.println("qua_com 업데이트 vo" + prd);
		count = quaMapper.prdComUpdate(prd);

		return count >= 1 ;
	}
	
	// 수정시 검사 공통 업데이트
	public int updateQc(List<QuaVO> list) {
		int count = 0;
		count = quaMapper.updateQc(list);
		return count;
	}

	// 수정시 검사 상세 업데이트

	@Override
	public List<QuaVO> updateQd(List<QuaVO> list) {
	    System.out.println("검사 상세 업데이트 서비스");
	    int count = 0;
	    for (int i = 0; i < list.size(); i++) {
	        QuaVO qua = list.get(i);
	        System.out.println("수정시 상세 업데이트 vo: " + qua);
	        int result = quaMapper.updateQd(qua);
	        if (result == 1) {
	            count++;
	        }
	    }

	    System.out.println("총 " + count + "개의 항목이 업데이트되었습니다.");
	    return list;
	}

	// 검사 결과 등록 완료 리스트
	@Override
	public List<PrdInspVO> prdComList() {
		return quaMapper.prdComList();
	}

	// 출고 검사 목록 리스트
	@Override
	public List<ShipInspVO> shInspList() {
		return quaMapper.shInspList();
	}

	// 출고 검사 등록
	@Transactional
	@Override
	public ShipInspVO shipInspAdd(ShipInspVO ship) {
		
		// 출고 검사 공통 등록
		String inspNum = quaMapper.psInspNum(); // 검사 번호 생성
		ship.setInspNum(inspNum);
		System.out.println("검사번호:"+inspNum);
		
		int amount = ship.getCpShipQt();
		String result = Integer.toString(ship.getCpShipQt()) ;
		if (ship.getResStat().equals("STAT-A")) {
			ship.setSuitQt(amount);
			ship.setNsuitQt(0);	
			ship.setResVal(result);
			ship.setCpShipStat("CP_SHIP_COMP");
		} else {
			ship.setSuitQt(0);
			ship.setNsuitQt(amount);
			ship.setResVal(result);
			ship.setCpShipStat("CP_SHIP_TRASH");
		}

		quaMapper.insertShipCom(ship);
				
		// 출고 검사 상세 등록
		String detNum = inspNum + "-" + String.format("%03d", +1); // inspNum-001 형식으로 설정
		ship.setDetInspNum(detNum);

		String inspId ="QR999";
		String inspType = "INSP-C";
		ship.setInspId(inspId);
		ship.setInspType(inspType);

		System.out.println(ship);
		
		quaMapper.insertShipDet(ship);
		
		// 완제품 출고 업데이트
		quaMapper.updateShip(ship);

		return ship;
	}

	// 출고 검사 수정
	@Transactional
	@Override
	public boolean shipInspMod(ShipInspVO ship) {
		int amount = ship.getCpShipQt();
		String result = Integer.toString(ship.getCpShipQt()) ;
		if (ship.getResStat().equals("STAT-A")) {
			ship.setResStat("STAT-A");
			ship.setSuitQt(amount);
			ship.setNsuitQt(0);	
			ship.setResVal(result);
			ship.setCpShipStat("CP_SHIP_COMP");
		} else {
			ship.setResStat("STAT-B");
			ship.setSuitQt(0);
			ship.setNsuitQt(amount);
			ship.setResVal(result);
			ship.setCpShipStat("CP_SHIP_TRASH");
		}
		System.out.println("서비스:" + ship);
		quaMapper.modShipDet(ship);
		quaMapper.modShipCom(ship);
		quaMapper.updateShip(ship);
		
		return true;

	}
	
	//출고 검사 단건 삭제
	@Override
	public boolean delShipInsp(QuaVO qua) {
		ShipInspVO vo = new ShipInspVO();
		String stdId = qua.getInspStdId();
		System.out.println("삭제할QuaVO:"+qua);
		System.out.println("업데이트ship:"+vo);
		vo.setCpShipId(stdId);
		vo.setCpShipStat("CP_SHIP_CHECK");
		quaMapper.updateShip(vo);
		return quaMapper.delInsp(qua) >= 1;
	}
	
	
	// 반품 리스트
	@Override
	public List<ReturnInspVO> returnList() {
		return quaMapper.returnList();
	}
	
	// 반품 검사 등록
	@Transactional
	@Override
	public ReturnInspVO returnInspAdd(ReturnInspVO ret) {
		
		// 품질 검사 공통 등록
		String inspNum = quaMapper.qrInspNum(); // 검사 번호 생성
		ret.setInspNum(inspNum);
		System.out.println("검사번호:"+inspNum);
		
		int amount = ret.getRetQt();
		String result = Integer.toString(ret.getRetQt()) ;
		if (ret.getResStat().equals("STAT-A")) {
			ret.setSuitQt(amount);
			ret.setNsuitQt(0);	
			ret.setResVal(result);
			ret.setRetStat("RETR");
		} else {
			ret.setSuitQt(0);
			ret.setNsuitQt(amount);
			ret.setResVal(result);
			ret.setRetStat("RETTRASH");
		}
		// 반품 검사 등록시 검사 공통 insert
		quaMapper.isnertReturnCom(ret);
		
		//반품 검사 상세 등록
			String detNum = inspNum + "-" + String.format("%03d", +1); // inspNum-001 형식으로 설정
			ret.setDetInspNum(detNum);

			String inspId ="QR999";
			String inspType = "INSP-D";
			ret.setInspId(inspId);
			ret.setInspType(inspType);

			System.out.println(ret);
				
			quaMapper.insertReturnDet(ret);
				
				// 완제품 출고 업데이트
				quaMapper.updateReturn(ret);
		
		return ret;
	}
	
	// 반품 검사 수정
	@Transactional
	@Override
	public boolean returnInspMod(ReturnInspVO ret) {
		
		int amount = ret.getRetQt();
		String result = Integer.toString(ret.getRetQt()) ;
		if (ret.getResStat().equals("STAT-A")) {
			ret.setSuitQt(amount);
			ret.setNsuitQt(0);	
			ret.setResVal(result);
			ret.setRetStat("RETR");
		} else {
			ret.setSuitQt(0);
			ret.setNsuitQt(amount);
			ret.setResVal(result);
			ret.setRetStat("RETTRASH");
		}
		quaMapper.modReturnDet(ret);
		quaMapper.modReturnCom(ret);
		quaMapper.updateReturn(ret);
		
		return true;
	}

	// 반품 검사 단건 삭제
	@Override
	public boolean delReturnInsp(QuaVO qua) {
		ReturnInspVO vo = new ReturnInspVO();
		String stdId = qua.getInspStdId();
		vo.setRetId(stdId);
		vo.setRetStat("RETREQ");
		quaMapper.updateReturn(vo);
		return quaMapper.delInsp(qua) >= 1;
	}

	
	

	// 장가애
	
	@Override // 검색용
	public List<QuaVO> searchInsp(QuaVO vo) {
		return quaMapper.searchInsp(vo);
	}

	@Override // 원천수 리스트
	public List<QuaVO> getWater() {
		return quaMapper.getWater();
	}

	@Override // 검사결과 리스트
	public List<QuaVO> resultInspList() {
		return quaMapper.resultInspList();
	}

	@Override // 검사결과 상세
	public List<QuaVO> getDetail(String inspNum) {
		return quaMapper.getDetail(inspNum);
	}


	
	

}
