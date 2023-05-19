package co.sixsu.app.work.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.work.domain.DetaProdPlanVO;
import co.sixsu.app.work.domain.PlanDataVO;
import co.sixsu.app.work.domain.SorderVO;
import co.sixsu.app.work.mapper.WorkMapper;
import co.sixsu.app.work.service.WorkService;

@Service("workService")
public class WorkServiceImpl implements WorkService{

	@Autowired WorkMapper mapper;

	@Override
	public Date getDate() {
		return mapper.getDate();
	}

	@Override
	public List<DetaProdPlanVO> getPlan() {
		System.out.println("getPlan 통과함");
		List<DetaProdPlanVO> list = mapper.getPlan();
		System.out.println(list);
		return list;
	}

	@Override
	public List<DetaProdPlanVO> getPlanFilter(PlanDataVO data) {
		System.out.println("WorkService로 들어온 데이터");
		System.out.println(data);
		List<DetaProdPlanVO> list = mapper.getPlanFilter(data);
		return list;
	}

	@Override
	public List<SorderVO> getSorder() {
		return mapper.getSorder();
	}
	
	
}
