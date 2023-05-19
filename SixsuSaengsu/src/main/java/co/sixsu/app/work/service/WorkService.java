package co.sixsu.app.work.service;

import java.util.Date;
import java.util.List;

import co.sixsu.app.work.domain.DetaProdPlanVO;
import co.sixsu.app.work.domain.PlanDataVO;
import co.sixsu.app.work.domain.SorderVO;

public interface WorkService {

	public Date getDate();
	
	public List<DetaProdPlanVO> getPlan();
	
	public List<DetaProdPlanVO> getPlanFilter(PlanDataVO data);

	public List<SorderVO> getSorder();
}
