package co.sixsu.app.service;

import java.util.Date;
import java.util.List;

import co.sixsu.app.domain.work.DetaProdPlanVO;

public interface WorkService {

	public Date getDate();
	
	public List<DetaProdPlanVO> getPlan();
	
}
