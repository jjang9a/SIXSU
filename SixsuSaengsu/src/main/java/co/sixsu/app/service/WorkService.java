package co.sixsu.app.service;

import java.util.Date;
import java.util.List;

import co.sixsu.app.domain.work.DetaProdPlanVO;
import co.sixsu.app.domain.work.PlanDataVO;

public interface WorkService {

	public Date getDate();
	
	public List<DetaProdPlanVO> getPlan();
	
	public List<DetaProdPlanVO> getPlanFilter(PlanDataVO data);
}
