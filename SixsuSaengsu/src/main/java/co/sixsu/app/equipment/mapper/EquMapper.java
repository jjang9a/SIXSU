package co.sixsu.app.equipment.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.equipment.domain.EquConVO;

@Mapper
public interface EquMapper {

	public List<EquConVO> equConList(); // 설비관리 정보 리스트

	public List<EquConVO> equList(); // 설비조회 전체리스트

	public List<EquConVO> equInfo(); // 설비조회 모달(상세정보) 리스트

	public List<EmpVO> empInfoList(String result); // 설비조회 모달(상세정보) 리스트

	public List<EquConVO> equFilterList(EquConVO data); // 조회 페이지 검색기능

	public int equAdd(EquConVO data); // 설비관리(등록)

	public int equUpdate(EquConVO data); // 설비관리(수정)

	public int equDel(String equCode); // 설비관리(삭제)
	
	
	


	


	
}
