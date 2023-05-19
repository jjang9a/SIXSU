package co.sixsu.app.work.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import co.sixsu.app.work.domain.DetaProdPlanVO;
import co.sixsu.app.work.domain.PlanDataVO;
import co.sixsu.app.work.domain.SorderVO;
import co.sixsu.app.work.domain.dataVO;
import co.sixsu.app.work.service.WorkService;

@RestController
@RequestMapping("ajax")
public class WorkAjaxController {
	
	@Autowired WorkService service;
	//@RequestParam(required = false)
	//@ResponseBody
	//contentType : application/json  
	//data : JSON.stringfy()
	
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
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@RequestMapping("sorderListAjax")
	public List sorderList() {
		List<SorderVO> list = service.getSorder();
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("addPlanAjax")
	public void addPlan(@ModelAttribute DetaProdPlanVO data) {
		System.out.println(data);
		return ;
	}
	
	
	
	
	
	
	
	
	@RequestMapping("test1")
	public List test1(@ModelAttribute()  dataVO data) {
		System.out.println(data);
		return null;
	}
	
	
} 
