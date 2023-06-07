package co.sixsu.app.work.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.sixsu.app.basic.domain.ProcessVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.material.domain.MatLotVO;
import co.sixsu.app.material.domain.MatVO;
import co.sixsu.app.work.domain.DetaProdPlanVO;
import co.sixsu.app.work.domain.DetaWorkOrdrVO;
import co.sixsu.app.work.domain.PlanDataVO;
import co.sixsu.app.work.domain.SorderVO;
import co.sixsu.app.work.domain.WorkFilterDataVO;
import co.sixsu.app.work.domain.addPlanVO;
import co.sixsu.app.work.domain.bomMatVO;
import co.sixsu.app.work.domain.detOrdVO;
import co.sixsu.app.work.domain.workBomVO;
import co.sixsu.app.work.service.WorkService;

//김인규 생산관리페이지
@RestController
@RequestMapping("ajax")
public class WorkAjaxController {
	
	@Autowired WorkService service;
	//@RequestParam(required = false)
	//@ResponseBody
	//contentType : application/json  
	//data : JSON.stringfy()
	
	@RequestMapping("planAjax")
	public List<DetaProdPlanVO> palnListData() {
		List<DetaProdPlanVO> list = service.getPlan();

		return list;
	}
	
	@RequestMapping("planFilterAjax")
	public List<DetaProdPlanVO> palnFilterListData(@RequestBody  PlanDataVO data) {
		System.out.println("받아들인 데이터 >");
		System.out.println(data);
		String checkFilter = "";
		
		if(data.getStatusCheckbox().length != 0) {
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
	
	@RequestMapping("getWorkList")
	public List<DetaWorkOrdrVO> getWorkList() {
		List<DetaWorkOrdrVO> list = service.getWorkList();
		return list;
	};
	@RequestMapping("getWorkListForProcess") //삭제 고민중... 쓰는곳이 없다
	public List<DetaWorkOrdrVO> getWorkListForProcess() {
		List<DetaWorkOrdrVO> list = service.getWorkListForProcess();
		return list;
	};
	@RequestMapping("workFilterAjax")
	public List<DetaWorkOrdrVO> workFilterAjax(@RequestBody WorkFilterDataVO data){
		System.out.println(data);
		List<DetaWorkOrdrVO> list = service.workFilterAjax(data);
		return list;
	}
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@RequestMapping(value = "addPlanAjax", method = RequestMethod.POST)
	@RequestMapping("addPlanAjax")
	public int addPlan(@RequestBody List<addPlanVO> data) {
		int result = service.addPlan(data);
		return result;
	}
		
	@RequestMapping("sorderListAjax")
	public List<SorderVO> sorderList() {
		List<SorderVO> list = service.getSorder();
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("detOrdListAjax")
	public List<detOrdVO> detOrdList(@RequestParam String ordId ) {
		List<detOrdVO> list = service.getdetOrd(ordId);
		System.out.println("클릭된 GRID2의 상세주문 내역 >");
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("getProductList")
	public List<ProductVO> getProductList() {
		List<ProductVO> list = service.getProductList();
		System.out.println("제품조회 리스트");
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("getPlanList")
	public List<addPlanVO> getPlanList() {
		List<addPlanVO> list = service.getPlanList();
		System.out.println("PROD_PLAN 의 데이터 >");
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("getDetaPlanList")
	public List<addPlanVO> getDetaPlanList(@RequestParam String planHeadId ) {
		List<addPlanVO> list = service.getDetaPlanList(planHeadId);
		System.out.println("클릭된 GRID2의 상세주문 내역 >");
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("getProcessList")
	public List<ProcessVO> getDetaPlanList() {
		List<ProcessVO> list = service.getProcessList();
		System.out.println("공정리스트 출력 >");
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("getMaterialList")
	public List<MatVO> getMaterialList() {
		List<MatVO> list = service.getMaterialList();
		System.out.println("자재 및 반제품 출력 >");
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("addDetaWork")
	public List<DetaWorkOrdrVO> addDetaWork(@RequestBody DetaWorkOrdrVO headId) {
		List<DetaWorkOrdrVO> list = service.addDetaWork(headId);
		return list;
	}
	
	/**
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping("getWkBomList")
	public List<workBomVO> getWkBomList(@RequestParam String data) {
		System.out.println("HIRE IS WorkAjaxController AND My data IS = " + data);
		List<workBomVO> list = service.getWkBomList(data);
		return list;
	}
	
	/**
	 * 
	 * @param data : 
	 * @return
	 */
	@RequestMapping("plusBomList")
	public List<workBomVO> plusBomList(@RequestParam String data) {
		System.out.println(data);
		List<workBomVO> list = service.plusBomList(data);
		return list;
	}
	
	@RequestMapping("getWkMatList")
	public List<bomMatVO> getWkMatList(@RequestParam String data) {
		System.out.println(data);
		List<bomMatVO> list = service.getWkMatList(data);
		return list;
	}
	
	@RequestMapping("plusMatList")
	public List<bomMatVO> plusMatList(@RequestParam String data) {
		System.out.println(data);
		List<bomMatVO> list = service.plusMatList(data);
		return list;
	}
	
	@RequestMapping("delBomList")
	public List<workBomVO> delBomList(@RequestBody List<workBomVO> data) {
		System.out.println(data);
		List<workBomVO> list = service.delBomList(data);
		return list;
	}
	
	@RequestMapping("delMatList")
	public List<bomMatVO> delMatList(@RequestBody List<bomMatVO> data) {
		System.out.println(data);
		List<bomMatVO> list = service.delMatList(data);
		return list;
	}
	
	@RequestMapping("delDetWorkList")
	public List<DetaWorkOrdrVO> delDetWorkList(@RequestBody List<DetaWorkOrdrVO> data) {
		System.out.println(data);
		List<DetaWorkOrdrVO> list = service.delDetWorkList(data);
		return list;
	}
	
	@RequestMapping("modifyMatList")
	public List<bomMatVO> modifyMatList(@RequestBody bomMatVO data) {
		System.out.println(data);
		List<bomMatVO> list = service.modifyMatList(data);
		return list;
	}
	@RequestMapping("modifyBomList")
	public List<workBomVO> modifyBomList(@RequestBody workBomVO data) {
		System.out.println(data);
		List<workBomVO> list = service.modifyBomList(data);
		return list;
	}
	@RequestMapping("modifyDetaWorkList")
	public List<Object> modifyDetaWorkList(@RequestBody DetaWorkOrdrVO data) {
		System.out.println(data);
		List<Object> allList = service.modifyDetaWorkList(data);
		return allList;
	}
	
	@RequestMapping("addSubmit")
	public String workInsertSubmit(@RequestBody DetaWorkOrdrVO wkDeta) {
		String message = service.workInsertSubmit(wkDeta);
		return message;
	}
	
	
	/**
	 * 
	 * @param data is 삭제를 위한 WK_HEAD_ID 코드
	 */
	@RequestMapping("workDataDelete")
	public void workDataDelete(@RequestParam String data) {
		System.out.println("HeadCode IS = " + data);
		service.workDataDelete(data);
	}
	
	/**
	 * 		  수정페이지 진입 시 HEAD_ID를 가져와 세부작업지시(List)를 출력한다
	 * @param data is 수정을 위한 WK_HEAD_ID
	 * @return
	 */
	@RequestMapping("modifyFirstList")
	public List<Object> modifyFirstList(@RequestParam String data) {
		System.out.println("HeadCode IS = " + data);
		List<Object> allList = service.modifyFirstList(data);
		return allList;
	}
	
	//미완성
	@RequestMapping("getBomMatList")
	public List<bomMatVO> getBomMatList(@RequestBody DetaWorkOrdrVO detaCode) {
		System.out.println("preparing getBomMatList");
		System.out.println("detaCode is " + detaCode.getWkDetaId());
		List<bomMatVO> list = service.getBomMatList(detaCode.getWkDetaId());
		return list;
	}
	
	@RequestMapping("startWorkOrder")
	public String startWorkOrder(@RequestBody DetaWorkOrdrVO detaCode) {
		System.out.println("preparing startWorkOrder");
		System.out.println("detaCode is " + detaCode.getWkDetaId());
		String result = service.startWorkOrder(detaCode.getWkDetaId());
		System.out.println(result);
		return result;
	}
	
	@RequestMapping("endWorkOrder")
	public String endWorkOrder(@RequestBody DetaWorkOrdrVO detaCode) {
		System.out.println("preparing endWorkOrder");
		System.out.println("detaCode is " + detaCode.getWkDetaId());
		String result = service.endWorkOrder(detaCode.getWkDetaId());
		System.out.println(result);
		return result;
	}
	
	@RequestMapping("getLotInfoList")
	public List<MatLotVO> getLotInfoList(@RequestBody bomMatVO bomMatId) {
		System.out.println("preparing endWorkOrder");
		System.out.println("detaCode is " + bomMatId.getBomMatId());
		return service.getLotInfoList(bomMatId.getBomMatId());
	}
	
	
} 
