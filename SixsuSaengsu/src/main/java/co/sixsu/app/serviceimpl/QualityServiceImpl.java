package co.sixsu.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.domain.material.MatreqVO;
import co.sixsu.app.domain.quality.QuaVO;
import co.sixsu.app.mapper.QualityMapper;
import co.sixsu.app.service.QualityService;

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


	/*
	 * @Override public int insertArr(QuaVO am) { return quaMapper.insertArr(am); }
	 */


	@Override
	public int mrUpdate(MatreqVO mat) {
		return quaMapper.mrUpdate(mat);
	}


	@Override
	public int insertArr(QuaVO am) {
		return quaMapper.insertArr(am); 
	}


	@Override
	public List<QuaVO> proRecList() {
		return quaMapper.proRecList();
	}
	
	

}
