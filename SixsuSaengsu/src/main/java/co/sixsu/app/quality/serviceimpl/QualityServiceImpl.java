package co.sixsu.app.quality.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.quality.domain.QuaVO;
import co.sixsu.app.quality.mapper.QualityMapper;
import co.sixsu.app.quality.service.QualityService;

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
	public List<QuaVO> inspItem() {
		return quaMapper.inspItem();
	}
	
	// 자재 입고 검사 결과 등록
	@Override
	public List<QuaVO> insertPri(List<QuaVO> list) {
		
		
		int count = 0; //insert 발생 횟수
		
		for(int i=0; i<list.size(); i++) {
				QuaVO qua = list.get(i);
				String detNum = qua.getInspNum(); //세부 지시 검사번호
				
				detNum += -i;
				qua.setDetInspNum(detNum);
				System.out.println(detNum);
				count += quaMapper.insertPr(list.get(i));
				System.out.println(count);
			
		}

		
		return list;
	}

	// 자재 입고 검사 결과 등록 시 업데이트
	@Override
	@Transactional
	public boolean priRegUpdate(QuaVO qua, MatreqVO mat) {
		int count = 0; // update 발생 횟수
		
		count += quaMapper.qComUpdate(qua);
		count += quaMapper.mUpdate(mat);
			
		
		return count >= 1;
	}








}
