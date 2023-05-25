package co.sixsu.app.material.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.sixsu.app.material.domain.MatLotVO;
import co.sixsu.app.material.domain.MatVO;
import co.sixsu.app.material.domain.MatrecVO;
import co.sixsu.app.material.domain.MatrecWaitVO;
import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.material.domain.SpRecWaitVO;

@Service
public interface MaterialsService {

	//발주 리스트
	List<MatreqVO> getMatReqList();
	
	//발주 단건 리스트
	List<MatreqVO> selectMatReq(int numId);
	
	//발주 행 삭제
	void deleteMatReq(String[] num);
	
	//발주 행 등록
	int insertMatReq(MatreqVO vo);
	
	//입고대기 리스트
	List<MatrecWaitVO> getMatRecWaitList();
	
	//입고 리스트
	List<MatrecVO> getMatRecList();
	
	//입고등록
	int insertMatRec(String reqId);
	
	//자재 리스트
	List<MatVO> selectMatList();
	
	//입고 행 삭제
	int deleteMatRec(String matLotId);
	
	//자재 lot 리스트
	List<MatLotVO> mLotList();
	
	//반제품 입고대기 리스트
	List<SpRecWaitVO> getSpWaitList();
}
