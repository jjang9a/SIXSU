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


	@Override
	@Transactional
	public boolean insertpro(List<QuaVO> list) {
		int count = 0;
		for(int i=0; i<list.size(); i++) {
			QuaVO curData = list.get(i);
			quaMapper.insertPro(curData);
			if(curData.getInspNum() != null ) count++;
		}
		return count >=1;
	}


	@Override
	public List<EmpVO> empList() {
		return quaMapper.empList();
	}

	



}
