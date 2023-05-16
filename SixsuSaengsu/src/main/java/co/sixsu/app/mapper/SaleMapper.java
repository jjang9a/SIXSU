package co.sixsu.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.sixsu.app.domain.common.EmpVO;

@Mapper
public interface SaleMapper {
	public List<EmpVO> empListAjax();
	public List<EmpVO> empList(); // popup 창의 사원목록
}
