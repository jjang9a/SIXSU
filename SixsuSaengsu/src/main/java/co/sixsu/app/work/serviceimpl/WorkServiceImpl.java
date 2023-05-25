package co.sixsu.app.work.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.sixsu.app.basic.domain.ProcessVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.material.domain.MatVO;
import co.sixsu.app.work.domain.DetaProdPlanVO;
import co.sixsu.app.work.domain.DetaWorkOrdrVO;
import co.sixsu.app.work.domain.PlanDataVO;
import co.sixsu.app.work.domain.SorderVO;
import co.sixsu.app.work.domain.addPlanVO;
import co.sixsu.app.work.domain.bomMatVO;
import co.sixsu.app.work.domain.detOrdVO;
import co.sixsu.app.work.domain.workBomVO;
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
	@Transactional
	public int addPlan(List<addPlanVO> data) {
		
		String hireDate = data.get(0).getRegDate();
		hireDate += "-";
		String headId = mapper.getIdDateAndData(hireDate);
		System.out.println("헤드데이터 : " + headId);
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
		
		
		return 0;
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
		int result = mapper.addWork(orderCode);
		if(result >0) {
			System.out.println("작업지시 생성성공! "+orderCode);
		}
		return orderCode;
	}

	@Override
	@Transactional
	public List<DetaWorkOrdrVO> addDetaWork(String data) {
		//세부지시에 쓸 ID가져오기
		String subData = data.substring(2) ;
		String detaCode = mapper.getDetaCode(subData);
		System.out.println(detaCode);
		//세부지시 추가
		DetaWorkOrdrVO ob = new DetaWorkOrdrVO();
		ob.setWkHeadId(data);
		ob.setWkDetaId(detaCode);
		mapper.addDetaWork(ob);
		//지시BOM추가
		mapper.addWkBom(detaCode);
		String bomCode = mapper.getBomCode(detaCode);
		//자재테이블 추가
		mapper.addWorkMatBom(bomCode);
		//list보낼거 선택
		List<DetaWorkOrdrVO> list = mapper.getDetaWorkHeadList(data);
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
	
	
}
