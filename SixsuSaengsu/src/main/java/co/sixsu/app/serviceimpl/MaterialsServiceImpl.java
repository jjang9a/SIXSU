package co.sixsu.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.domain.material.MatreqVO;
import co.sixsu.app.mapper.MaterialsMapper;
import co.sixsu.app.service.MaterialsService;

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
		public int deleteMatReq(int num) {
			return mapper.deleteMatReq(num);
		}
		
}
