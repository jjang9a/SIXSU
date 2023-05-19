package co.sixsu.app.material.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.sixsu.app.material.domain.MatreqVO;

@Service
public interface MaterialsService {

	//발주 리스트
	List<MatreqVO> getMatReqList();
	
	//발주 단건 리스트
	List<MatreqVO> selectMatReq(int numId);
	
	//행 삭제
	int deleteMatReq(int num); 
}
