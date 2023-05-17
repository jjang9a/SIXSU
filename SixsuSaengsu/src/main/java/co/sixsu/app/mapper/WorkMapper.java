package co.sixsu.app.mapper;

import java.util.Date;
import java.util.List;

import co.sixsu.app.domain.work.DetaProdPlanVO;

public interface WorkMapper {

	public Date getDate();
	public List<DetaProdPlanVO> getPlan();
	
}
