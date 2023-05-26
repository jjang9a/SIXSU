package co.sixsu.app.material.mapper;

import java.util.List;

import co.sixsu.app.material.domain.MatAdjVO;
import co.sixsu.app.material.domain.MatAdjVO;
import co.sixsu.app.material.domain.MatLotVO;
import co.sixsu.app.material.domain.MatShipVO;
import co.sixsu.app.material.domain.MatVO;
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
	
	//자재 입고
	int insertMatRec(String matReqId);
	
	//자재 리스트
	List<MatVO> selectMatList();
	
	//입고 리스트에서 삭제
	int deleteMatRec(String matLotId);
	
	//자재 lot 리스트
	List<MatLotVO> mLotList();
	
	//자재 lot 리스트
	int deleteMLot(String matLotId);
	
	//자재 출고 리스트
	List<MatShipVO> getMatShipList();
	
	//자재 재고조정 리스트
	List<MatAdjVO> getMatAdjList();
	
	//자재 조정입고
	int matRecAdj(MatAdjVO vo);
}
