package co.sixsu.app.work.mapper;

import java.util.Date;
import java.util.List;

import co.sixsu.app.work.domain.DetaProdPlanVO;
import co.sixsu.app.work.domain.PlanDataVO;

public interface WorkMapper {

	public Date getDate();
	public List<DetaProdPlanVO> getPlan();
	public List<DetaProdPlanVO> getPlanFilter(PlanDataVO data);
	
}
