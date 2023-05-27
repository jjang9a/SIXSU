package co.sixsu.app.quality.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.quality.domain.PrdInspVO;
import co.sixsu.app.quality.domain.QuaVO;
import co.sixsu.app.quality.mapper.QualityMapper;
import co.sixsu.app.quality.service.QualityService;
import co.sixsu.app.work.domain.DetaWorkOrdrVO;

@Service("QualityService")
public class QualityServiceImpl implements QualityService {
	@Autowired QualityMapper quaMapper;
	
	
	@Override
	public List<QuaVO> getArrList() {//도착 자재 리스트 출력
		return quaMapper.getArrList();
	}


	@Override
	public List<QuaVO> arrRegList() {
		return quaMapper.arrRegList();
	}

	@Override
	public boolean mrUpdate(List<MatreqVO> mlist) {
		int count = 0; //insert 발생 횟수
		for(int i=0; i<mlist.size(); i++) {

				count += quaMapper.mrUpdate(mlist.get(i));
			
		}
		return count >= 1;
	}


	@Override
	public int insertArr(QuaVO am) {
		return quaMapper.insertArr(am); 
	}


	@Override
	public List<QuaVO> proRecList() {
		return quaMapper.proRecList();
	}


	@Override
	public boolean insertPr(List<QuaVO> qlist) {
		int count = 0; //insert 발생 횟수
		for(int i=0; i<qlist.size(); i++) {

				count += quaMapper.insertPr(qlist.get(i));
			
		}
		return count >= 1;
	}


	@Override
	public List<QuaVO> prInspList() {
		return quaMapper.prInspList();
	}

	//입고 검사 등록 시 검사 번호 자동 등록
	@Override
	public String psInspNum() {
		return quaMapper.psInspNum();
	}

	// 입고 검사 등록 프로시저 사용
	@Override
	@Transactional
	public List<QuaVO> insertpro(List<QuaVO> list) {
		int count = 0;

		for(int i=0; i<list.size(); i++) {
			//String num = quaMapper.psInspNum();
			//System.out.println("검사번호:"+num);
			//list.get(i).setInspNum(num);
			
			QuaVO curData = list.get(i);
			
			System.out.println("검사번호 포함된 vo:"+curData);
			
			quaMapper.insertPro(curData);
			System.out.println("insertPor:"+curData);
			if(curData.getInspNum() != null ) count++;
		}
		
		return list;
	}


	/*
	 * // 자재 입고 검사 결과 등록
	 * 
	 * @Override
	 * 
	 * @Transactional public boolean insertPri(QuaVO qua, MatreqVO mat) {
	 * 
	 * int count = 0; // insert 결과
	 * 
	 * for() quaMapper.insertPri(qua); quaMapper.qComUpdate(qua);
	 * quaMapper.mUpdate(mat);
	 * 
	 * return count >= 1; }
	 */
	
	// 검사 항목 가져오기
	@Override
	public List<QuaVO> inspItem(String matId) {
		return quaMapper.inspItem(matId);
	}
	
	// 자재 입고 검사 결과 등록
	@Override
	public List<QuaVO> insertPri(List<QuaVO> list) {
		
		System.out.println("서비스");
		int count = 0; //insert 발생 횟수
		
		for(int i=0; i<list.size(); i++) {
				QuaVO qua = list.get(i);
				String detNum = qua.getInspNum(); //세부 지시 검사번호
				String un = "-";

				detNum += -i;
				qua.setDetInspNum(detNum);
				System.out.println(detNum);
				
				if(qua.getResVal()==null) {
					qua.setResVal(un);
				};
				
				
				count += quaMapper.insertPri(list.get(i));
				System.out.println(count);
			
		}

		
		return list;
	}

	// 자재 입고 검사 결과 등록 시 업데이트
	@Override
	@Transactional
	public boolean priRegUpdate(QuaVO qua) {
		int count = 0; // update 발생 횟수
		
		count += quaMapper.qComUpdate(qua);
		count += quaMapper.mUpdate(qua);
			
		
		return count >= 1;
	}
	
	// insert+update 합침
	@Override
	@Transactional
	public List<QuaVO> insertPriAndUpdate(List<QuaVO> list) {
	    System.out.println("서비스");
	    int count = 0; // insert 발생 횟수

	    for (int i = 0; i < list.size(); i++) {
	        QuaVO qua = list.get(i);
	        String inspNum = qua.getInspNum(); // 세부 지시 검사번호
	        String detNum = inspNum + "-" + String.format("%03d", i + 1); // inspNum-001 형식으로 설정
	        String un = "-";

	        qua.setDetInspNum(detNum);
	        System.out.println(detNum);

	        if (qua.getResVal() == null) {
	            qua.setResVal(un);
	        }

	        count += quaMapper.insertPri(list.get(i));
	        System.out.println(count);

	        if (i == list.size() - 1) {
	            count += quaMapper.qComUpdate(qua);
	            
	            System.out.println("insertPri"+qua);
	            count += quaMapper.mUpdate(qua);
	            System.out.println("insertPri mUpdate"+qua);
	        }
	    }

	    return list;
	}
	
//	@Override
//	@Transactional
//	public List<QuaVO> insertPriAndUpdate(List<QuaVO> list) {
//	    System.out.println("서비스");
//	    int count = 0; // insert 발생 횟수
//
//	    for (int i = 0; i < list.size(); i++) {
//	        QuaVO qua = list.get(i);
//	        String detNum = qua.getInspNum() + "-" + i; // 세부 지시 검사번호 생성
//	        String un = "-";
//
//	        qua.setDetInspNum(detNum);
//	        System.out.println(detNum);
//
//	        if (qua.getResVal() == null) {
//	            qua.setResVal(un);
//	        }
//
//	        count += quaMapper.insertPri(list.get(i));
//	        System.out.println(count);
//
//	        if (i == list.size() - 1) {
//	            count += quaMapper.qComUpdate(qua);
//	            count += quaMapper.mUpdate(qua);
//	        }
//	    }
//
//	    return list;
//	}

	// 자재 입고 검사 결과 등록 프로시저 사용
//	@Override
//	public List<QuaVO> reqInspProc(List<QuaVO> list) {
//		int count = 0; // insert 발생 횟수
//
//	    for (QuaVO qua : list) {
//	        String detNum = qua.getInspNum(); // 세부 지시 검사번호
//	        String un = "-";
//
//	        detNum += "-" + list.indexOf(qua);
//	        qua.setDetInspNum(detNum);
//	        System.out.println(detNum);
//
//	        if (qua.getResVal() == null) {
//	            qua.setResVal(un);
//	        }
//
//	        // 프로시저 호출을 위한 필드 설정
//	        qua.setCount(count + 1); // 프로시저 매개변수 v_count 설정
//
//	        // 프로시저 실행
//	        quaMapper.reqInspProc(qua);
//
//	        count++;
//	    }
//
//	    System.out.println(count);
//	    return list;
//	}
	
	// 공정 검사 전 리스트 출력
	@Override
	public List<DetaWorkOrdrVO> bpAddList() {
		return quaMapper.bpAddList();
	}


	@Override
	public boolean bpdAdd(List<PrdInspVO> list) {
		// TODO Auto-generated method stub
		return false;
	}





}
