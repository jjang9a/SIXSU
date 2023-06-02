package co.sixsu.app.material.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.sixsu.app.material.domain.MatAdjVO;
import co.sixsu.app.material.domain.MatDmgVO;
import co.sixsu.app.material.domain.MatLotVO;
import co.sixsu.app.material.domain.MatShipVO;
import co.sixsu.app.material.domain.MatVO;
import co.sixsu.app.material.domain.MatrecVO;
import co.sixsu.app.material.domain.MatrecWaitVO;
import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.material.domain.SpAdjVO;
import co.sixsu.app.material.domain.SpDmgVO;
import co.sixsu.app.material.domain.SpShipVO;
import co.sixsu.app.material.domain.SpVO;

@Service
public interface MaterialsService {

	//발주 리스트
	List<MatreqVO> getMatReqList();
	
	//발주 행 삭제
	void deleteMatReq(List<MatreqVO> vo);
	
	//발주 행 등록
	int insertMatReq(MatreqVO vo);
	
	//발주 수정
	void updateMatReq(List<MatreqVO> vo);
	
	//입고대기 리스트
	List<MatrecWaitVO> getMatRecWaitList();
	
	//입고 리스트
	List<MatrecVO> getMatRecList();
	
	//입고등록
	void insertMatRec(List<MatrecVO> vo);
	
	//자재 리스트
	List<MatVO> selectMatList(MatVO vo);
	
	//입고 행 삭제
	void delMatRec(List<MatrecVO> vo);
	
	//자재 lot 리스트
	List<MatLotVO> mLotList(MatLotVO vo);
	
	//자재 출고 리스트
	List<MatShipVO> getMatShipList();
	
	//자재 재고조정 리스트
	List<MatAdjVO> getMatAdjList();
	
	//자재 조정입고
	void matRecAdj(List<MatAdjVO> vo);
	
	//자재 조정출고
	void matShipAdj(List<MatAdjVO> vo);
	
	//반제품 재고조정 리스트
	List<SpAdjVO> getSpAdjList();
	
	//반제품 출고 리스트
	List<SpShipVO> getSpShipList();
	
	//반제품 조정입고
	void spRecAdj(List<SpAdjVO> vo);
	
	//반제품 조정출고
	void spShipAdj(List<SpAdjVO> vo);
	
	//반제품 불량처리대기 리스트
	List<SpDmgVO> getSpDmgWaitList();
	
	//반제품 불량처리 리스트
	List<SpDmgVO> getSpDmgList();
	
	//반제품 풀량처리
	void insertSpDmg(List<SpDmgVO> vo);
	
	//자재 불량처리대기 리스트
	List<MatDmgVO> getMatDmgWaitList();
	
	//자재 불량처리 리스트
	List<MatDmgVO> getMatDmgList();
	
	//자재 불량 처리
	void insertMatDmg(List<MatDmgVO> vo);
	
	//반제품 리스트
	List<SpVO> getSpList();
	
	//불량품 처리대기 리스트
	List<MatDmgVO> getMatDamageWaitList2();
	
	//불량품 리스트
	List<MatDmgVO> getMatDmgList2();
	
	//불량품 불량 처리
	void insertMatDmg2(List<MatDmgVO> vo);
}
