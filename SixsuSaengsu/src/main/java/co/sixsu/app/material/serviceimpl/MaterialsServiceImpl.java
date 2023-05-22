package co.sixsu.app.material.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.material.domain.MatrecWaitVO;
import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.material.mapper.MaterialsMapper;
import co.sixsu.app.material.service.MaterialsService;

@Service("MaterialsService")
public class MaterialsServiceImpl implements MaterialsService{

		@Autowired MaterialsMapper mapper;

		@Override
		public List<MatreqVO> getMatReqList() {
			return mapper.getMatReqList();
		}

		@Override
		public List<MatreqVO> selectMatReq(int nuqId) {
			return mapper.selectMatReq(nuqId);
		}

		@Override
		public int deleteMatReq(String num) {
			return mapper.deleteMatReq(num);
		}

		@Override
		public int insertMatReq(MatreqVO vo) {
			return mapper.insertMatReq(vo);
		}

		@Override
		public List<MatrecWaitVO> getMatRecWaitList() {
			return mapper.getMatRecWaitList();
		}
		
}
