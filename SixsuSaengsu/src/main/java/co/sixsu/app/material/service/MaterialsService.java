package co.sixsu.app.material.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.sixsu.app.material.domain.MatrecVO;
import co.sixsu.app.material.domain.MatrecWaitVO;
import co.sixsu.app.material.domain.MatreqVO;

@Service
public interface MaterialsService {

	//발주 리스트
	List<MatreqVO> getMatReqList();
	
	//발주 단건 리스트
	List<MatreqVO> selectMatReq(int numId);
	
	//발주 행 삭제
	int deleteMatReq(String num);
	
	//발주 행 등록
	int insertMatReq(MatreqVO vo);
	
	//입고대기 리스트
	List<MatrecWaitVO> getMatRecWaitList();
	
	//입고 리스트
	List<MatrecVO> getMatRecList();
	
	//int insertMatRec(String reqId);
	
	//입고등록
	int insertMatRec(String reqId);
}
