package co.sixsu.app.quality.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


	@Override
	public int insertPr(QuaVO am) {
		return quaMapper.insertPr(am);
	}


	@Override
	public List<QuaVO> prInspList() {
		return quaMapper.prInspList();
	}
	
	

}
