package co.sixsu.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.domain.quality.ArrMatVO;
import co.sixsu.app.mapper.QualityMapper;
import co.sixsu.app.service.QualityService;

@Service("QualityService")
public class QualityServiceImpl implements QualityService {
	@Autowired QualityMapper quaMapper;
	
	
	@Override
	public List<ArrMatVO> getArrList() {//도착 자재 리스트 출력
		return quaMapper.getArrList();
	}

}
