package co.sixsu.app.material.mapper;

import java.util.List;

import co.sixsu.app.basic.domain.BusVO;
import co.sixsu.app.material.domain.MatAdjVO;
import co.sixsu.app.material.domain.MatDmgVO;
import co.sixsu.app.material.domain.MatLotVO;
import co.sixsu.app.material.domain.MatShipVO;
import co.sixsu.app.material.domain.MatVO;
import co.sixsu.app.material.domain.MatrecVO;
import co.sixsu.app.material.domain.MatrecWaitVO;
import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.material.domain.SpAdjVO;
import co.sixsu.app.material.domain.SpLotVO;
import co.sixsu.app.material.domain.SpShipVO;
import co.sixsu.app.material.domain.SpVO;

public interface MaterialsMapper {
	
	
	//발주 리스트
	List<MatreqVO> getMatReqList();
	
	//발주 조회
	List<MatreqVO> getMatReqSearch(MatreqVO vo);
	
	//발주 리스트에서 삭제
	int deleteMatReq(MatreqVO vo);
	
	//발주 등록
	int insertMatReq(MatreqVO vo);
	
	//발주 수정
	int updateMatReq(MatreqVO vo);
	
	//발주 거래처
	List<BusVO> matReqBusList();
	
	//입고대기 리스트
	List<MatrecWaitVO> selectMatRecWaitList();
	
	//입고 리스트
	List<MatrecVO> selectMatRecList();
	
	//입고 조회 리스트
	List<MatrecVO> getMatRecSearch(MatrecVO vo);
	
	//자재 입고
	int insertMatRec(MatrecVO vo);
	
	//자재 리스트
	List<MatVO> selectMatList(MatVO vo);
	
	//입고 리스트에서 삭제
	int delMatRec(MatrecVO vo);
	
	//자재 lot 리스트
	List<MatLotVO> mLotList(MatLotVO vo);
	
	//자재 출고 리스트
	List<MatShipVO> getMatShipList(MatShipVO vo);
	
	//자재 재고조정 리스트
	List<MatAdjVO> getMatAdjList(String matLotId);
	
	//자재 조정입고
	int matRecAdj(MatAdjVO vo);
	
	//자재 조정출고
	int matShipAdj(MatAdjVO vo);
	
	//반제품 재고조정 리스트
	List<SpAdjVO> getSpAdjList(String spLotId);
	
	//반제품 출고 리스트
	List<SpShipVO> getSpShipList(SpShipVO vo);
	
	//반제품 조정입고
	int spRecAdj(SpAdjVO vo);
	
	//반제품 조정출고
	int spShipAdj(SpAdjVO vo);
	
	//반제품 리스트
	List<SpVO> getSpList(String spName);
	
	//불량자재 처리대기 리스트
	List<MatDmgVO> getMatDmgWaitList();
	
	//불량자재 리스트
	List<MatDmgVO> getMatDmgList(MatDmgVO vo);
	
	//불량자재 처리
	int insertMatDmg(MatDmgVO vo);
	
	//반제품 LOT 리스트
	List<SpLotVO> getSpLotList(SpLotVO vo);
	
}
