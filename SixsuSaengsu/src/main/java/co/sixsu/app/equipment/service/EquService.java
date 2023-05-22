package co.sixsu.app.equipment.service;

import java.util.List;

import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.equipment.domain.EquConVO;

public interface EquService {

	List<EquConVO> equList(); // 설비 조회 리스트
	
	List<EquConVO> equInfo(String equCode); // 클릭시(불러올데이터)

	List<EmpVO> empInfoList(String result); // 모달에 띄워줄 리스트

	List<EquConVO> equFilterList(EquConVO data); // 검색
	
	List<EquConVO> equConList(); // 설비 관리 리스트
	
	boolean equAdd(EquConVO data); // 설비관리(등록)

	boolean equUpdate(EquConVO data); // 설비관리(수정)

	boolean equDel(String equCode); // 설비관리(삭제)
	
}
