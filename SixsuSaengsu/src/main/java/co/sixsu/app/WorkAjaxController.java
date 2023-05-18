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

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import co.sixsu.app.domain.work.DetaProdPlanVO;
import co.sixsu.app.domain.work.PlanDataVO;
import co.sixsu.app.domain.work.dataVO;
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
	public List palnFilterListData(@ModelAttribute  PlanDataVO data) {
		System.out.println("받아들인 데이터 >");
		System.out.println(data);
		String checkFilter = "";
		
		if(data.getStatusCheckbox() != null) {
			checkFilter += "AND (status IN (";
			for(int i=0;i<data.getStatusCheckbox().length;i++) {
				String j = "\'" + data.getStatusCheckbox()[i] + "\'";
				if(i < data.getStatusCheckbox().length-1) {
					j += ",";
				}
				checkFilter += j;
			}
			checkFilter += "))";
			data.setStatusFilter(checkFilter);
			System.out.println(checkFilter);
		}
		List<DetaProdPlanVO> list = service.getPlanFilter(data);
		
		return list;
	}
	
	@RequestMapping("test1")
	public List test1(@ModelAttribute  dataVO data) {
		System.out.println(data);
		return null;
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