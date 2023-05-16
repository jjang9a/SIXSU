package co.sixsu.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ajax")
public class AjaxController {
	
	@RequestMapping("toastList")
	public List toastList() {
		System.out.println("ajax 들어오긴 했음");
		List list = new ArrayList();
		Map map = new HashMap();
		map.put("name",  "a");
		map.put("artist",  "b");
		map.put("type",  "c");
		map.put("release",  "1.1.1.0");
		map.put("genre",  "M");
		list.add(map);
		list.add(map);
		list.add(map);
		list.add(map);
		list.add(map);
		list.add(map);
		return list;
	}
	
	@RequestMapping("work1Ajax")
	public List toastDataList() {
		List list = new ArrayList();
		PlanData data = new PlanData("정기계획", "20230515-1", "SML-7", "바오자켈가","800","0","2023-05-31","2023-05-30","2023-05-31"," ");
		list.add(data);
		return list;
	}
}

@lombok.Data
class PlanData {
	private String type;
	private String planDetaId;
	private String matId;
	private String matName;
	private String ordQt;
	private String goodQt;
	private String ordDueDate;
	private String startDate;
	private String endDate;
	private String memo;
	
	public PlanData() {
		
	}
	public PlanData(String type,String planDetaId,String matId,String matName,String ordQt,String goodQt,String ordDueDate,String startDate,String endDate,String memo) {
		this.type = type;
		this.planDetaId = planDetaId;
		this.matId = matId;
		this.matName = matName;
		this.ordQt = ordQt;
		this.goodQt = goodQt;
		this.ordDueDate = ordDueDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.memo = memo;
		
	}
}

@lombok.Data
class DataTest {
	String name;
	String artist;
	String type;
	String release;
	String genre;
	
	public DataTest(String name,String artist,String type,String release,String genre) {
		
	}
}