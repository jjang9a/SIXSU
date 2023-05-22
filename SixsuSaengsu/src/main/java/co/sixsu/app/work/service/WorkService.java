package co.sixsu.app.work.service;

import java.util.Date;
import java.util.List;

import co.sixsu.app.work.domain.DetaProdPlanVO;
import co.sixsu.app.work.domain.PlanDataVO;
import co.sixsu.app.work.domain.SorderVO;
import co.sixsu.app.work.domain.addPlanVO;
import co.sixsu.app.work.domain.detOrdVO;

public interface WorkService {

	public Date getDate();
	
	public List<DetaProdPlanVO> getPlan();
	
	public List<DetaProdPlanVO> getPlanFilter(PlanDataVO data);

	public List<SorderVO> getSorder();

	public List<detOrdVO> getdetOrd(String ordId);

	public int addPlan(List<addPlanVO> data);
}
