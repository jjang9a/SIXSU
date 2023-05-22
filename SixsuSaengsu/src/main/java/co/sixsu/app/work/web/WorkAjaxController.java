package co.sixsu.app.work.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.work.domain.DetaProdPlanVO;
import co.sixsu.app.work.domain.PlanDataVO;
import co.sixsu.app.work.domain.SorderVO;
import co.sixsu.app.work.domain.addPlanVO;
import co.sixsu.app.work.domain.detOrdVO;
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
	//@RequestMapping(value = "addPlanAjax", method = RequestMethod.POST)
	@RequestMapping("addPlanAjax")
	public void addPlan(@RequestBody List<addPlanVO> data) {
		System.out.println(data.size());
		for(addPlanVO i : data) {
			System.out.println(i);
			System.out.println(i.getOrdDetId());
			System.out.println(i.getCpId());
			System.out.println(i.getOrdQt());
		}
		int result = service.addPlan(data);
		return ;
	}
		
	@RequestMapping("sorderListAjax")
	public List sorderList() {
		List<SorderVO> list = service.getSorder();
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("detOrdListAjax")
	public List detOrdList(@RequestParam String ordId ) {
		List<detOrdVO> list = service.getdetOrd(ordId);
		System.out.println("클릭된 GRID2의 상세주문 내역 >");
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("getProductList")
	public List getProductList() {
		List<ProductVO> list = service.getProductList();
		System.out.println("제품조회 리스트");
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("getPlanList")
	public List getPlanList() {
		List<addPlanVO> list = service.getPlanList();
		System.out.println("PROD_PLAN 의 데이터 >");
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("getDetaPlanList")
	public List getDetaPlanList(@RequestParam String planHeadId ) {
		List<addPlanVO> list = service.getDetaPlanList(planHeadId);
		System.out.println("클릭된 GRID2의 상세주문 내역 >");
		System.out.println(list);
		return list;
	}
	
	
} 
