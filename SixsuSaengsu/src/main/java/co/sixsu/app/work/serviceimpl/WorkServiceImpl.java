package co.sixsu.app.work.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.sixsu.app.work.domain.DetaProdPlanVO;
import co.sixsu.app.work.domain.PlanDataVO;
import co.sixsu.app.work.domain.SorderVO;
import co.sixsu.app.work.domain.addPlanVO;
import co.sixsu.app.work.domain.detOrdVO;
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

	@Override
	public List<detOrdVO> getdetOrd(String ordId) {
		return mapper.getdetOrd(ordId);
	}

	@Override
	public int addPlan(List<addPlanVO> data) {
		
		String hireDate = data.get(0).getRegDate();
		hireDate += "-";
		String headId = mapper.getIdDateAndData(hireDate);
		System.out.println("헤드데이터 : " + headId);
		//생산계획의 ID 부여
		data.get(0).setPlanHeadId(headId);
		System.out.println("data.get(0)");
		System.out.println(data.get(0));
		int result = mapper.addProdPlan(data.get(0));
		System.out.println("result");
		System.out.println(result);
		
		
		//세부계획의 ID부여
		System.out.println("세부생산계획 add데이터");
		for(int i=1;i<data.size();i++) {
			data.get(i).setPlanHeadId(headId);
			data.get(i).setPlanDetaId((headId + "-" + i).substring(2));
			System.out.println("data.get("+i+")");
			System.out.println(data.get(i));
			result += mapper.addDetProdPlan(data.get(i));
		}
		System.out.println("result");
		System.out.println(result);
		//int result = mapper.addPlan(data);
		
		
		return 0;
	}
	
	
}
