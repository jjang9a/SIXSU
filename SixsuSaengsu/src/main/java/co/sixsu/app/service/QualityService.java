package co.sixsu.app.service;

import java.util.List;

import co.sixsu.app.domain.quality.ArrMatVO;

public interface QualityService {
	
	//도착자재 조회
	List<ArrMatVO> getArrList();

}
