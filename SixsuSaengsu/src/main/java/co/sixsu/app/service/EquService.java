package co.sixsu.app.service;

import java.util.List;

import co.sixsu.app.domain.common.EmpVO;
import co.sixsu.app.domain.equipment.EquConVO;

public interface EquService {

	List<EquConVO> equList(); // 설비 조회 리스트
	
	List<EquConVO> equConList(); // 설비 관리 리스트
	
	List<EquConVO> equInfo(String equCode); // (불러올데이터)

	List<EmpVO> empInfoList(String result); // 모달에 띄워줄 리스트
	
}
