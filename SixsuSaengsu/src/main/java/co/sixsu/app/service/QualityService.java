package co.sixsu.app.service;

import java.util.List;

import co.sixsu.app.domain.quality.ArrMatVO;

public interface QualityService {
	
		List<ArrMatVO> getArrList(); // 도착자재 조회
		List<ArrMatVO> arrRegList(); // 도착 자재 등록 리스트
		int insertArr(ArrMatVO vo); // 도착 자재 등록

}
