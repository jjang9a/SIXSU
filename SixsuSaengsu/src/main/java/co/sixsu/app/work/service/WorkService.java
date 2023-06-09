package co.sixsu.app.work.service;

import java.util.Date;
import java.util.List;

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

public interface WorkService {

	public Date getDate();
	
	public List<DetaProdPlanVO> getPlan();
	
	public List<DetaProdPlanVO> getPlanFilter(PlanDataVO data);

	public List<SorderVO> getSorder();

	public List<detOrdVO> getdetOrd(String ordId);

	public int addPlan(List<addPlanVO> data);

	public List<ProductVO> getProductList();

	public List<addPlanVO> getPlanList();

	public List<addPlanVO> getDetaPlanList(String planHeadId);

	public List<ProcessVO> getProcessList();

	public List<MatVO> getMaterialList();

	public String addWork();

	public List<DetaWorkOrdrVO> addDetaWork(DetaWorkOrdrVO data);

	public List<workBomVO> getWkBomList(String data);

	public List<workBomVO> plusBomList(String data);

	public List<bomMatVO> getWkMatList(String data);

	public List<bomMatVO> plusMatList(String data);

	public List<workBomVO> delBomList(List<workBomVO> data);

	public List<bomMatVO> delMatList(List<bomMatVO> data);

	public List<DetaWorkOrdrVO> delDetWorkList(List<DetaWorkOrdrVO> data);

	public List<bomMatVO> modifyMatList(bomMatVO data);

	public List<workBomVO> modifyBomList(workBomVO data);

	public List<Object> modifyDetaWorkList(DetaWorkOrdrVO data);

	public String workInsertSubmit(DetaWorkOrdrVO wkDeta);

	public List<DetaWorkOrdrVO> getWorkList();

	public List<DetaWorkOrdrVO> workFilterAjax(WorkFilterDataVO data);

	public String workDataDelete(String data);

	public List<Object> modifyFirstList(String data);

	public String startWorkOrder(String detaCode);

	public String endWorkOrder(String wkDetaId);

	public List<DetaWorkOrdrVO> getWorkListForProcess();

	public List<bomMatVO> getBomMatList(String detaCode);

	public List<MatLotVO> getLotInfoList(String bomMatId);

	public List<DetaWorkOrdrVO> addWorkforPlan(List<DetaWorkOrdrVO> planData);


}
