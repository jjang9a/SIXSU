package co.sixsu.app.work.mapper;

import java.util.Date;
import java.util.List;

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


public interface WorkMapper {

	public Date getDate();
	public List<DetaProdPlanVO> getPlan();
	public List<DetaProdPlanVO> getPlanFilter(PlanDataVO data);
	public List<SorderVO> getSorder();
	public List<detOrdVO> getdetOrd(String ordId);
	//public int addPlan(List<addPlanVO> data);
	public String getIdDateAndData(String data);
	public int addProdPlan(addPlanVO addPlanVO);
	public int addDetProdPlan(addPlanVO addPlanVO);
	public List<ProductVO> getProductList();
	public List<addPlanVO> getPlanList();
	public List<addPlanVO> getDetaPlanList(String planHeadId);
	public List<ProcessVO> getProcessList();
	public List<MatVO> getMaterialList();
	public String getOrderCode();
	public int addWork(String orderCode);
	public String getDetaCode(String subData);
	public void addDetaWork(DetaWorkOrdrVO ob);
	public void addWkBom(String detaCode);
	public List<DetaWorkOrdrVO> getDetaWorkHeadList(String data);
	public List<workBomVO> getWkBomList(String data);
	public String getBomCode(String detaCode);
	public void addWorkMatBom(String bomCode);
	public List<bomMatVO> getWkMatList(String data);
	public void delBomList(List<workBomVO> data);
	public void delMatList(List<bomMatVO> data);
	public void delBeideMat(List<workBomVO> data);
	public void delDetWorkList(List<DetaWorkOrdrVO> data);
	public void delBeideBom(List<DetaWorkOrdrVO> data);

}
