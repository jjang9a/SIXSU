package co.sixsu.app.mapper;

import java.util.Date;
import java.util.List;

import co.sixsu.app.domain.common.EmpVO;

public interface CommonMapper {

	public Date getDate();
	
	public List<EmpVO> empList();

}
