package co.sixsu.app.work.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import co.sixsu.app.work.mapper.WorkMapper;
import co.sixsu.app.work.service.WorkService;

@Service
public class WorkServiceImpl implements WorkService{

	@Autowired WorkMapper mapper;

	@Override
	public Date getDate() {
		return mapper.getDate();
	}

	@Override
	public List<DetaProdPlanVO> getPlan() {
		List<DetaProdPlanVO> list = mapper.getPlan();
		return list;
	}

	@Override
	public List<DetaProdPlanVO> getPlanFilter(PlanDataVO data) {
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
	@Transactional
	public int addPlan(List<addPlanVO> data) {
		String hireDate = data.get(0).getRegDate();
		hireDate += "-";
		String headId = mapper.getIdDateAndData(hireDate);
		//생산계획의 ID 부여
		data.get(0).setPlanHeadId(headId);
		int result = mapper.addProdPlan(data.get(0));
		
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
		
		
		return result;
	}

	@Override
	public List<ProductVO> getProductList() {
		return mapper.getProductList();
	}

	@Override
	public List<addPlanVO> getPlanList() {
		return mapper.getPlanList();
	}

	@Override
	public List<addPlanVO> getDetaPlanList(String planHeadId) {
		List<addPlanVO> list = mapper.getDetaPlanList(planHeadId);
		System.out.println(list);
		return list;
	}

	@Override
	public List<ProcessVO> getProcessList() {
		List<ProcessVO> list = mapper.getProcessList();
		return list;
	}

	@Override
	public List<MatVO> getMaterialList() {
		List<MatVO> list = mapper.getMaterialList();
		return list;
	}

	@Override
	public String addWork() {
		String orderCode = mapper.getOrderCode();
		mapper.addWork(orderCode);
		return orderCode;
	}

	@Override
	@Transactional
	public List<DetaWorkOrdrVO> addDetaWork(DetaWorkOrdrVO headId) {
		//세부지시에 쓸 ID가져오기
		String subData = headId.getWkHeadId().substring(2) ;
		String detaCode = mapper.getDetaCode(subData);
		//세부지시 추가
		DetaWorkOrdrVO ob = headId;
		ob.setWkDetaId(detaCode);
		mapper.addDetaWork(ob);
		//list보낼거 선택
		List<DetaWorkOrdrVO> list = mapper.getDetaWorkHeadList(headId.getWkHeadId());
		return list;
		
	}
	//세부지시 클릭할떄 마다 해당 공정리스트 출력함
	@Override
	public List<workBomVO> getWkBomList(String data) {
		return mapper.getWkBomList(data);
	}

	@Override
	@Transactional
	public List<workBomVO> plusBomList(String detaCode) {
		mapper.addWkBom(detaCode);
		List<workBomVO> list = mapper.getWkBomList(detaCode);
		
		return list;
	}

	@Override
	public List<bomMatVO> getWkMatList(String data) {
		return mapper.getWkMatList(data);
	}

	@Override
	@Transactional
	public List<bomMatVO> plusMatList(String bomCode) {
		mapper.addWorkMatBom(bomCode);
		List<bomMatVO> list = mapper.getWkMatList(bomCode);
		return list;
	}

	@Override
	@Transactional
	public List<workBomVO> delBomList(List<workBomVO> data) {
		mapper.delBomList(data);
		mapper.delBeideMat(data);
		List<workBomVO> list = mapper.getWkBomList(data.get(0).getWkDetaId());
		return list;
	}

	@Override
	@Transactional
	public List<bomMatVO> delMatList(List<bomMatVO> data) {
		mapper.delMatList(data);
		List<bomMatVO> list = mapper.getWkMatList(data.get(0).getWkBomId());
		return list;
	}

	@Override
	@Transactional
	public List<DetaWorkOrdrVO> delDetWorkList(List<DetaWorkOrdrVO> data) {
		mapper.delDetWorkList(data);
		mapper.delBeideBom(data);
		List<DetaWorkOrdrVO> list = mapper.getDetaWorkHeadList(data.get(0).getWkHeadId());
		return list;
	}

	@Override
	@Transactional
	public List<bomMatVO> modifyMatList(bomMatVO data) {
		String id = data.getWkBomId();
		mapper.modifyMatList(data);
		List<bomMatVO> list = mapper.getWkMatList(id);
		return list;
	}

	@Override
	public List<workBomVO> modifyBomList(workBomVO data) {
		mapper.modifyBomList(data);
		List<workBomVO> list = mapper.getWkBomList(data.getWkDetaId());
		return list;
	}

	@Override
	public List<Object> modifyDetaWorkList(DetaWorkOrdrVO data) {
		mapper.modifyDetaWorkList(data);
		List<Object> allList = new ArrayList<>();
		allList.add(mapper.getDetaWorkHeadList(data.getWkHeadId()));
		boolean test = data.getSingle() == "Y";
		if("Y".equals(data.getSingle())) {
			mapper.getProductBomList(data);
			
		}
		System.out.println(data);
		return allList;
	}

	@Override
	public String workInsertSubmit(DetaWorkOrdrVO wkDeta) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("wkHeadId", wkDeta.getWkHeadId());
		paramMap.put("empId", wkDeta.getEmpId());
		paramMap.put("cmpltSt", wkDeta.getCmpltSt());
		paramMap.put("outParam", null);
		
		mapper.workInsertSubmit(paramMap);
		
		String outParam = (String) paramMap.get("outParam");
		System.out.println("작동여부");
		System.out.println(outParam);
		return outParam;
	}

	@Override
	public String workDataDelete(String data) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("inParam", data);
		paramMap.put("outParam", null);
		mapper.workDataDelete(paramMap);
		String outValue = (String) paramMap.get("outParam");
		System.out.println(outValue);
		
		return outValue;
	}

	@Override
	public List<DetaWorkOrdrVO> getWorkList() {
		return mapper.getWorkList();
	}
	
	@Override //삭제 고민중... 쓰는곳이 없다
	public List<DetaWorkOrdrVO> getWorkListForProcess() {
		return mapper.getWorkListForProcess();
	}


	@Override
	public List<DetaWorkOrdrVO> workFilterAjax(WorkFilterDataVO data) {
		String checkFilter = "";
		if(data.getStatusCheckbox().length != 0) {
			checkFilter += "AND (CMPLT_ST IN (";
			for(int i=0;i<data.getStatusCheckbox().length;i++) {
				String j = "\'" + data.getStatusCheckbox()[i] + "\'";
				if(i < data.getStatusCheckbox().length-1) {
					j += ",";
				}
				checkFilter += j;
			}
			checkFilter += "))";
			System.out.println("============================");
			System.out.println(checkFilter);
			data.setStatusFilter(checkFilter);
			System.out.println("정돈된 checkFilter : " + checkFilter);
		}
		System.out.println(data.getWorkFrom());
		System.out.println(data.getWorkTo());
		List<DetaWorkOrdrVO> list = mapper.workFilterAjax(data);
		return list;
	}

	@Override
	public List<Object> modifyFirstList(String data) {
		List<Object> allList = new ArrayList<>();
		allList.add(mapper.getPlanList());
		allList.add(mapper.getDetaWorkHeadList(data));
		return allList;
	}

	@Override
	public String startWorkOrder(String detaCode) {
		String headCode = "20" + detaCode.substring(0,9);
		
		String[] parts = headCode.split("-");  // 문자열을 '-' 기호를 기준으로 분리하여 배열로 저장
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < parts.length - 1; i++) {
		    sb.append(parts[i]);
		    System.out.println(parts[i]);
		    if (i < parts.length - 2) {
		        sb.append("-");
		    }
		} 
		sb.insert(0, "20");
		System.out.println(sb);
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("headCode", headCode);
		paramMap.put("detaCode", detaCode);
		paramMap.put("resultParam", null);
		mapper.startWorkOrder(paramMap);
		String result = (String) paramMap.get("resultParam"); 
		return result;
	}

	@Override
	public String endWorkOrder(String wkDetaId) {
		Map<String, Object> paramMap = new HashMap<>();
		System.err.println(wkDetaId);
		paramMap.put("detaCode", wkDetaId);
		paramMap.put("resultParam", null);
		mapper.endWorkOrder(paramMap);
		return (String) paramMap.get("resultParam");
	}

	@Override
	public List<bomMatVO> getBomMatList(String detaCode) {
		return mapper.getBomMatList(detaCode);
	}

	@Override
	public List<MatLotVO> getLotInfoList(String bomMatId) {
		return mapper.getLotInfoList(bomMatId);
	}

	@Override
	public List<DetaWorkOrdrVO> addWorkforPlan(List<DetaWorkOrdrVO> planData) {
		
		for(DetaWorkOrdrVO vo : planData) {
			System.err.println(planData.size());
			//세부지시에 쓸 ID가져오기
			String subData = vo.getWkHeadId().substring(2) ;
			String detaCode = mapper.getDetaCode(subData);
			
			DetaWorkOrdrVO ob = vo;
			ob.setWkDetaId(detaCode);
			//세부지시 INSERT
			mapper.addDetaWork(ob);
			
			//생산계획과 LINK하기
			mapper.addLink(ob);
		}
		
		List<DetaWorkOrdrVO> allList = mapper.getDetaWorkHeadList(planData.get(0).getWkHeadId());
		return allList;
	}

	
	
}
