package co.sixsu.app.quality.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.sixsu.app.basic.domain.EmpVO;
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
			String num = quaMapper.psInspNum();
			System.out.println("검사번호:"+num);
			list.get(i).setInspNum(num);
			
			QuaVO curData = list.get(i);
			
			System.out.println("검사번호 포함된 vo:"+curData);
			
			quaMapper.insertPro(curData);
			System.out.println("insertPor:"+curData);
			if(curData.getInspNum() != null ) count++;
		}
		
		return list;
	}



	// 자재 입고 검사 결과 등록
	@Override
	public boolean insertPri(QuaVO qua) {
		int count = 0; // insert 결과
		quaMapper.insertPri(qua);
		return count >= 1;
	}

	



}
