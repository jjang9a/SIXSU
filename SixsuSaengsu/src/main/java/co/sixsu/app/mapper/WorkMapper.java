package co.sixsu.app.mapper;

import java.util.Date;
import java.util.List;

import co.sixsu.app.domain.work.DetaProdPlanVO;
import co.sixsu.app.domain.work.PlanDataVO;

public interface WorkMapper {

	public Date getDate();
	public List<DetaProdPlanVO> getPlan();
	public List<DetaProdPlanVO> getPlanFilter(PlanDataVO data);
	
}
