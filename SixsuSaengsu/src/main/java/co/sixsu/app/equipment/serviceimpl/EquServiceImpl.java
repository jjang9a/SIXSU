package co.sixsu.app.equipment.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.equipment.domain.EquConVO;
import co.sixsu.app.equipment.mapper.EquMapper;
import co.sixsu.app.equipment.service.EquService;

@Service("EquService")
public class EquServiceImpl implements EquService{

	@Autowired EquMapper mapper;
	
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

	@Override
	public List<EquConVO> equFilterList(EquConVO data) { // 검색기능
		return mapper.equFilterList(data);
	}
	
	@Override
	public List<EquConVO> equConList() { // 설비 관리 리스트
		return mapper.equConList();
	}

	@Override
	public boolean equAdd(EquConVO data) { // 설비관리(등록)
		return mapper.equAdd(data) == 1;
	}

	@Override
	public boolean equUpdate(EquConVO data) { // 설비관리(수정)
		return mapper.equUpdate(data) == 1;
	}

	@Override
	public boolean equDel(String equCode) { // 설비관리(삭제)
		return mapper.equDel(equCode) == 1;
	}

}
