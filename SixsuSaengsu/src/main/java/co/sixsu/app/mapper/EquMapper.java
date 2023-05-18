package co.sixsu.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.sixsu.app.domain.common.EmpVO;
import co.sixsu.app.domain.equipment.EquConVO;

@Mapper
public interface EquMapper {

	List<EquConVO> equConList(); // 설비관리 정보 리스트

	List<EquConVO> equList(); // 설비조회 전체리스트

	List<EquConVO> equInfo(); // 설비조회 모달(상세정보) 리스트

	List<EmpVO> empInfoList(String result); // 설비조회 모달(상세정보) 리스트
	
	
	
   // int insertequ(EquContVO vo); // 설비관리 등록


	


	
}
