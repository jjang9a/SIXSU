package co.sixsu.app.equipment.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.equipment.domain.EquConVO;
import co.sixsu.app.equipment.domain.EquInspVO;
import co.sixsu.app.equipment.domain.EquOperVO;
import co.sixsu.app.equipment.domain.EquSearchDTO;
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
	public List<EquConVO> equFilterList(EquSearchDTO dto) { // 설비조회(검색)
		return mapper.equFilterList(dto);
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
	public List<ProductVO> activePdList() { // 설비관리 공정코드(조회) ajax
		return mapper.activePdList();
	}
	
	@Override
	public boolean equUpdate(EquConVO data) { // 설비관리(수정)
		System.out.println("서비스 도착 " + data);
		return mapper.equUpdate(data) == 1;
	}

	@Override
	public boolean equDel(EquConVO equCode) { // 설비관리(삭제)
		return mapper.equDel(equCode) == 1;
	}

	@Override
	public List<EquInspVO> equCheckList() { // 점검 리스트
		return mapper.equCheckList();
	}

	@Override
	public List<EquInspVO> equCheckSearch(EquSearchDTO dto) { //점검조회(검색)
		return mapper.equCheckSearch(dto);
	}

	@Override
	public boolean checkAdd(EquInspVO data) { // 점검관리(등록) 
		return mapper.checkAdd(data) == 1;
	}

	@Override
	public boolean cUpdate(EquInspVO data) { // 점검관리(수정)
		return mapper.cUpdate(data) == 1;
	}
	
	@Override
	public boolean cDel(EquInspVO checkCode) { // 점검관리(삭제)
		return mapper.cDel(checkCode) == 1;
	}
	
	@Override
	public List<EquOperVO> equOperList() { // 비가동 리스트
		return mapper.equOperList();
	}

	@Override
	public List<EquOperVO> equOperSearch(EquSearchDTO dto) { // 비가동 조회(검색)
		return mapper.equOperSearch(dto);
	}

	@Override
	public boolean oUpdate(EquOperVO data) { // 비가동 관리(수정)
		return mapper.oUpdate(data) == 1;
	}

	@Override
	public boolean oDel(EquOperVO operCode) { // 비가동 관리(삭제)
		return mapper.oDel(operCode) == 1;
	}

	@Override
	public boolean startIn(EquOperVO data) { // 비가동 관리 시작버튼(등록)
		return mapper.startIn(data) == 1;
	}

	@Override
	public boolean startUp(EquOperVO data) { // 비가동 관리 시작버튼(수정/설비상태)
		return mapper.startUp(data) == 1;
	}

	


	



	

}
