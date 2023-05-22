package co.sixsu.app.material.mapper;

import java.util.List;

import co.sixsu.app.material.domain.MatrecVO;
import co.sixsu.app.material.domain.MatrecWaitVO;
import co.sixsu.app.material.domain.MatreqVO;

public interface MaterialsMapper {
	
	
	//발주 리스트
	List<MatreqVO> getMatReqList();
	
	//단건 조회
	List<MatreqVO> selectMatReq(int reqId);
	
	//발주 리스트에서 삭제
	int deleteMatReq(String reqId);
	
	//발주 등록
	int insertMatReq(MatreqVO vo);
	
	//입고대기 리스트
	List<MatrecWaitVO> selectMatRecWaitList();
	
	//입고 리스트
	List<MatrecVO> selectMatRecList();
	
	int insertMatRec(String reqId);
}
