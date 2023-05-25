package co.sixsu.app.equipment.service;

import java.util.List;

import co.sixsu.app.equipment.domain.EquConVO;

public interface EquService {

	List<EquConVO> equList(); // 설비 리스트

	List<EquConVO> equFilterList(EquConVO data); // 검색 기능
	
    List<EquConVO> equConList(); // 설비 관리 리스트
	
	boolean equAdd(EquConVO data); // 설비관리(등록)

	boolean equUpdate(EquConVO data); // 설비관리(수정)

	boolean equDel(EquConVO equCode); // 설비관리(삭제)

	//List<EquConVO> equCheckList(); // 설비 점검 리스트

	
	
}
