package co.sixsu.app.material.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.material.domain.SpLotVO;
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
		
		//발주 조회
		@Override
		public List<MatreqVO> getMatReqSearch(MatreqVO vo) {
			return mapper.getMatReqSearch(vo);
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
		
		//발주 거래처 리스트
		@Override
		public List<BusVO> matReqBusList() {
			return mapper.matReqBusList();
		}
		
		//자재 입고대기 리스트
		@Override
		public List<MatrecWaitVO> getMatRecWaitList() {
			return mapper.selectMatRecWaitList();
		}
		
		//자재 입고 리스트
		@Override
		public List<MatrecVO> getMatRecList() {
			return mapper.selectMatRecList();
		}
		
		//자재 입고 조회 리스트
		@Override
		public List<MatrecVO> getMatRecSearch(MatrecVO vo) {
			return mapper.getMatRecSearch(vo);
		}
		
		//자재 입고 등록
		@Override
		public void insertMatRec(List<MatrecVO> vo) {
			String id = vo.get(0).getEmpId();
			for(MatrecVO i : vo) {
				i.setEmpId(id);
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
			String id = vo.get(0).getEmpId();
			for(MatAdjVO i : vo) {
				i.setEmpId(id);
				mapper.matRecAdj(i);
			}
		}

		//자재 조정출고
		@Override
		public void matShipAdj(List<MatAdjVO> vo) {
			String id = vo.get(0).getEmpId();
			for(MatAdjVO i : vo) {
				i.setEmpId(id);
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
		
		//반제품 조정입고
		@Override
		public void spRecAdj(List<SpAdjVO> vo) {
			String id = vo.get(0).getEmpId();
			for(SpAdjVO i : vo) {
				i.setEmpId(id);
				mapper.spRecAdj(i);
			}
		}
		
		//반제품 조정출고
		@Override
		public void spShipAdj(List<SpAdjVO> vo) {
			String id = vo.get(0).getEmpId();
			for(SpAdjVO i : vo) {
				i.setEmpId(id);
				mapper.spShipAdj(i);
			}
			
		}
		
		//반제품 리스트
		@Override
		public List<SpVO> getSpList(String spName) {
			return mapper.getSpList(spName);
		}

		//불량자재 처리대기 리스트
		@Override
		public List<MatDmgVO> getMatDmgWaitList() {
			return mapper.getMatDmgWaitList();
		}
		
		//불량자재 리스트
		@Override
		public List<MatDmgVO> getMatDmgList(MatDmgVO vo) {
			return mapper.getMatDmgList(vo);
		}
		
		//불량자재 불량처리
		@Override
		public void insertMatDmg(List<MatDmgVO> vo) {
			String stat = vo.get(0).getDmatResult();
			String id = vo.get(0).getEmpId();
			for(MatDmgVO i : vo) {
				i.setDmatStat(stat);
				i.setEmpId(id);
				mapper.insertMatDmg(i);
			}
			
		}
		
		//반제품 LOT 리스트
		@Override
		public List<SpLotVO> getSpLotList(SpLotVO vo) {
			return mapper.getSpLotList(vo);
		}
		





		

}
