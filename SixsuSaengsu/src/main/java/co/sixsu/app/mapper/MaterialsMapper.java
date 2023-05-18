package co.sixsu.app.mapper;

import java.util.List;

import co.sixsu.app.domain.material.MatreqVO;

public interface MaterialsMapper {
	
	
	//발주 리스트
	List<MatreqVO> getMatReqList();
	
	//단건조회
	List<MatreqVO> selectMatReq(int reqId);
	
	//단건 리스트 삭제
	int deleteMatReq(int reqId);
	
}
