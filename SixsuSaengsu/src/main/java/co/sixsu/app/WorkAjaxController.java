package co.sixsu.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.sixsu.app.domain.work.DetaProdPlanVO;
import co.sixsu.app.service.WorkService;

@RestController
@RequestMapping("ajax")
public class WorkAjaxController {
	
	@Autowired WorkService service;
	
	@RequestMapping("planAjax")
	public List palnListData() {
		List<DetaProdPlanVO> list = service.getPlan();

		return list;
	}
	
	@RequestMapping("planFilterAjax")
	public List palnFilterListData(@ModelAttribute  PlanData data) {
		System.out.println(data);

		return null;
	}
} 

@lombok.Data
class PlanData {
	private String productName;
	private String planNo;
	private String writer;
	private String planCheckbox;
	private String statusCheckbox;
	
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