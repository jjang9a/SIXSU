package co.sixsu.app.equipment.service;

import java.util.List;

import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.equipment.domain.EquConVO;

public interface EquService {

	List<EquConVO> equList(); // 설비 조회 리스트
	
	List<EquConVO> equConList(); // 설비 관리 리스트
	
	List<EquConVO> equInfo(String equCode); // (불러올데이터)

	List<EmpVO> empInfoList(String result); // 모달에 띄워줄 리스트

	List<EquConVO> equFilterList(EquConVO data); // 검색
	
}
