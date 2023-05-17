package co.sixsu.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.sixsu.app.domain.equipment.EquConVO;

@Mapper
public interface EquMapper {

	List<EquConVO> equConList(); // 설비관리 정보 리스트

	


	
}
