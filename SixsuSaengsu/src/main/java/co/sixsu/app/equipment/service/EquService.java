package co.sixsu.app.equipment.service;

import java.util.List;

import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.equipment.domain.EquConVO;
import co.sixsu.app.equipment.domain.EquInspVO;
import co.sixsu.app.equipment.domain.EquOperVO;
import co.sixsu.app.equipment.domain.EquSearchDTO;

public interface EquService {

	List<EquConVO> equList(); // 설비 리스트

	List<EquConVO> equFilterList(EquSearchDTO dto); // 검색 기능
	
    List<EquConVO> equConList(); // 설비 관리 리스트
	
	boolean equAdd(EquConVO data); // 설비관리(등록)
	
	List<ProductVO> activePdList(); // 등록 공정코드(조회) ajax

	boolean equUpdate(EquConVO data); // 설비관리(수정)

	boolean equDel(EquConVO equCode); // 설비관리(삭제)

	List<EquInspVO> equCheckList(); // 점검 조회 리스트
	
	List<EquInspVO> equCheckSearch(EquSearchDTO dto); // 점검 조회 검색 기능

	List<EquOperVO> equOperList(); // 비가동 리스트
	
	List<EquOperVO> equOperSearch(EquSearchDTO dto); // 점검 조회 검색 기능

	
	
}
