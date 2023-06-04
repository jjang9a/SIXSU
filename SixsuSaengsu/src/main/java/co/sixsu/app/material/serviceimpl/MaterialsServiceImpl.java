package co.sixsu.app.material.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.material.domain.SpDmgVO;
import co.sixsu.app.material.domain.MatAdjVO;
import co.sixsu.app.material.domain.MatDmgVO;
import co.sixsu.app.material.domain.MatLotVO;
import co.sixsu.app.material.domain.MatShipVO;
import co.sixsu.app.material.domain.MatVO;
import co.sixsu.app.material.domain.MatrecVO;
import co.sixsu.app.material.domain.MatrecWaitVO;
import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.material.domain.SpAdjVO;
import co.sixsu.app.material.domain.SpShipVO;
import co.sixsu.app.material.domain.SpVO;
import co.sixsu.app.material.mapper.MaterialsMapper;
import co.sixsu.app.material.service.MaterialsService;

@Service("MaterialsService")
public class MaterialsServiceImpl implements MaterialsService{

		@Autowired MaterialsMapper mapper;
		
		//발주 리스트
		@Override
		public List<MatreqVO> getMatReqList() {
			return mapper.getMatReqList();
		}
		
		//발주 삭제
		@Override
		public void deleteMatReq(List<MatreqVO> vo) {
			for(MatreqVO i : vo) {
				mapper.deleteMatReq(i);
			}
		}
		
		//발주 등록
		@Override
		public int insertMatReq(MatreqVO vo) {
			return mapper.insertMatReq(vo);
		}
		
		//발주 수정
		@Override
		public void updateMatReq(List<MatreqVO> vo) {
			for(MatreqVO i : vo) {
				mapper.updateMatReq(i);
			}
		}
		
		//입고대기 리스트
		@Override
		public List<MatrecWaitVO> getMatRecWaitList() {
			return mapper.selectMatRecWaitList();
		}
		
		//입고 리스트
		@Override
		public List<MatrecVO> getMatRecList() {
			return mapper.selectMatRecList();
		}
		
		//입고 등록
		@Override
		public void insertMatRec(List<MatrecVO> vo) {
			for(MatrecVO i : vo) {
				mapper.insertMatRec(i);
			}
		}
		
		//자재 리스트
		@Override
		public List<MatVO> selectMatList(MatVO vo) {
			return mapper.selectMatList(vo);
		}
		
		//입고 리스트 삭제
		@Override
		public void delMatRec(List<MatrecVO> vo) {
			int cnt = 0;
			for(MatrecVO i : vo) {
				mapper.delMatRec(i);
				if (i.getOutMessage().equals("1")) {
					cnt ++;
				}
			}
			System.out.println("abc");
			System.out.println(cnt);
		}
		
		//자재 LOT 리스트
		@Override
		public List<MatLotVO> mLotList(MatLotVO vo) {
			return mapper.mLotList(vo);
		}
		
		//자재 출고내역 리스트
		@Override
		public List<MatShipVO> getMatShipList(MatShipVO vo) {
			return mapper.getMatShipList(vo);
		}
		
		//자재 재고조정 리스트
		@Override
		public List<MatAdjVO> getMatAdjList(String matLotId) {
			return mapper.getMatAdjList(matLotId);
		}
		
		//자재 조정입고
		@Override
		public void matRecAdj(List<MatAdjVO> vo) {
			for(MatAdjVO i : vo) {
				mapper.matRecAdj(i);
			}
		}

		//자재 조정출고
		@Override
		public void matShipAdj(List<MatAdjVO> vo) {
			for(MatAdjVO i : vo) {
				mapper.matShipAdj(i);
			}
			
		}
		
		//반제품 재고조정 리스트
		@Override
		public List<SpAdjVO> getSpAdjList(String spLotId) {
			return mapper.getSpAdjList(spLotId);
		}
		
		//반제품 출고 리스트
		@Override
		public List<SpShipVO> getSpShipList(SpShipVO vo) {
			return mapper.getSpShipList(vo);
		}
		
		//자재 조정입고
		@Override
		public void spRecAdj(List<SpAdjVO> vo) {
			for(SpAdjVO i : vo) {
				mapper.spRecAdj(i);
			}
		}
		
		//자재 조정출고
		@Override
		public void spShipAdj(List<SpAdjVO> vo) {
			for(SpAdjVO i : vo) {
				mapper.spShipAdj(i);
			}
			
		}
		
		//반제품 불량처리대기 리스트
		@Override
		public List<SpDmgVO> getSpDmgWaitList() {
			return mapper.getSpDmgWaitList();
		}
		
		//반제품 불량처리 리스트
		@Override
		public List<SpDmgVO> getSpDmgList() {
			return mapper.getSpDmgList();
		}
		
		//반제품 불량처리
		@Override
		public void insertSpDmg(List<SpDmgVO> vo) {
			String stat = vo.get(0).getDspStat();
			for(SpDmgVO i : vo) {
				i.setDspStat(stat);
				mapper.insertSpDmg(i);
				System.out.println("abcd");
				System.out.println(i);
			}
			
		}
		
		//자재 불량처리대기 리스트
		@Override
		public List<MatDmgVO> getMatDmgWaitList() {
			return mapper.getMatDmgWaitList();
		}

		//자재 불량처리 리스트
		@Override
		public List<MatDmgVO> getMatDmgList() {
			return mapper.getMatDmgList();
		}

		//자재 불량처리
		@Override
		public void insertMatDmg(List<MatDmgVO> vo) {
			String stat = vo.get(0).getDmatStat();
			for(MatDmgVO i : vo) {
				i.setDmatStat(stat);
				mapper.insertMatDmg(i);
			}
			
		}
		
		//반제품 리스트
		@Override
		public List<SpVO> getSpList(String spName) {
			return mapper.getSpList(spName);
		}

		//불량품 처리대기 리스트
		@Override
		public List<MatDmgVO> getMatDamageWaitList2() {
			return mapper.getMatDamageWaitList2();
		}
		
		//불량품 리스트
		@Override
		public List<MatDmgVO> getMatDmgList2() {
			return mapper.getMatDmgList2();
		}
		
		//불량품 불량처리
		@Override
		public void insertMatDmg2(List<MatDmgVO> vo) {
			String stat = vo.get(0).getDmatStat();
			for(MatDmgVO i : vo) {
				i.setDmatStat(stat);
				mapper.insertMatDmg(i);
			}
			
		}
		

}
