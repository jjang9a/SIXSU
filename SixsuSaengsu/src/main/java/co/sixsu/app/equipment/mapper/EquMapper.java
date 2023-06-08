package co.sixsu.app.equipment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.equipment.domain.EquConVO;
import co.sixsu.app.equipment.domain.EquInspVO;
import co.sixsu.app.equipment.domain.EquOperVO;
import co.sixsu.app.equipment.domain.EquSearchDTO;

@Mapper
public interface EquMapper {

	public List<EquConVO> equConList(); // 설비관리 정보 리스트

	public List<EquConVO> equList(); // 설비조회 전체리스트

	public List<EquConVO> equFilterList(EquSearchDTO dto); // 설비 조회 페이지 검색기능

	public int equAdd(EquConVO data); // 설비관리(등록)
	
	public List<ProductVO> activePdList(); // 등록 공정코드(조회) ajax

	public int equUpdate(EquConVO data); // 설비관리(수정)

	public int equDel(EquConVO equCode); // 설비관리(삭제)
	public int equcheckDel(EquConVO equCode); // 점검에서 설비(삭제)
	public int equoperDel(EquConVO equCode); // 비가동에서 설비(삭제)

	public List<EquInspVO> equCheckList(); // 설비 점검 리스트
	
	public List<EquInspVO> equCheckSearch(EquSearchDTO dto); // 점검 조회 페이지 검색기능
	
	public int checkAdd(EquInspVO data); // 점검관리(등록) 
	
	public int cUpdate(EquInspVO data); // 점검관리 (수정) 
	
	public int cDel(EquInspVO checkCode); // 점검관리 (삭제)
	
	public List<EquOperVO> equOperList(); // 비가동 리스트

	public List<EquOperVO> equOperSearch(EquOperVO vo); // 비가동 조회(검색)

	public int oUpdate(EquOperVO data); // 비가동 관리(수정)

	public int oDel(EquOperVO operCode); // 비가동 관리(삭제)

	public int startIn(EquOperVO data); // 비가동 관리 시작버튼(등록)
	
	public int startUp(EquOperVO data); // 비가동 관리 시작버튼(수정/설비상태)

	public int fnishIn(EquOperVO data); // 비가동 관리 비가동 종료버튼(가동 등록) 
	
	public int fnishUp(EquOperVO data); // 비가동 관리 비가동 종료버튼(수정/설비상태)

	

	
	
	


	


	
}
