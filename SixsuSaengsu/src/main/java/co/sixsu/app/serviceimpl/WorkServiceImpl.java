package co.sixsu.app.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.domain.work.DetaProdPlanVO;
import co.sixsu.app.mapper.WorkMapper;
import co.sixsu.app.service.WorkService;

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
	
	
}
