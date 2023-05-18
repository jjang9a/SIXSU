package co.sixsu.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.domain.common.EmpVO;
import co.sixsu.app.domain.equipment.EquConVO;
import co.sixsu.app.mapper.EquMapper;
import co.sixsu.app.service.EquService;

@Service("EquService")
public class EquServiceImpl implements EquService{

	@Autowired EquMapper mapper;
	
	@Override
	public List<EquConVO> equConList() { // 설비 관리 리스트
		return mapper.equConList();
	}

	@Override
	public List<EquConVO> equList() { // 설비 조회 리스트
		return mapper.equList();
	}

	@Override
	public List<EquConVO> equInfo(String equCode) { 
		return mapper.equInfo();
	}

	@Override
	public List<EmpVO> empInfoList(String result) { // 설비조회 모달창
		return mapper.empInfoList(result);
	}

}
