package co.sixsu.app.material.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.material.domain.MatLotVO;
import co.sixsu.app.material.domain.MatVO;
import co.sixsu.app.material.domain.MatrecVO;
import co.sixsu.app.material.domain.MatrecWaitVO;
import co.sixsu.app.material.domain.MatreqVO;
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
		
		//발주번호로 조회 --- 수정필요!
		@Override
		public List<MatreqVO> selectMatReq(int nuqId) {
			return mapper.selectMatReq(nuqId);
		}

		
		//발주 삭제
		@Override
		public int deleteMatReq(String num) {
			return mapper.deleteMatReq(num);
		}
		
		//발주 등록
		@Override
		public int insertMatReq(MatreqVO vo) {
			return mapper.insertMatReq(vo);
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
		public int insertMatRec(String reqId) {
			return mapper.insertMatRec(reqId);
		}
		
		//자재 리스트
		@Override
		public List<MatVO> selectMatList() {
			return mapper.selectMatList();
		}
		
		//입고 리스트 삭제
		@Override
		public int deleteMatRec(String matLotId) {
			int result = mapper.deleteMatRec(matLotId);
			result += mapper.deleteMLot(matLotId);
			return result;
		}

		@Override
		public List<MatLotVO> mLotList() {
			return mapper.mLotList();
		}
		
		
}
