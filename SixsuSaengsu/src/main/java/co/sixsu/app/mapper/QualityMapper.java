package co.sixsu.app.mapper;

import java.util.List;

import co.sixsu.app.domain.quality.ArrMatVO;

public interface QualityMapper {
	List<ArrMatVO> getArrList(); // 도착 자재 리스트
	List<ArrMatVO> arrRegList(); // 도착 자재 등록 리스트
	int insertArr(ArrMatVO vo); // 도착 자재 등록

}
