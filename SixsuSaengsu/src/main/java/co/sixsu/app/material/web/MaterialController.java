package co.sixsu.app.material.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.basic.service.BasicService;
import co.sixsu.app.material.domain.MatAdjVO;
import co.sixsu.app.material.domain.MatDmgVO;
import co.sixsu.app.material.domain.MatLotVO;
import co.sixsu.app.material.domain.MatShipVO;
import co.sixsu.app.material.domain.MatVO;
import co.sixsu.app.material.domain.MatrecVO;
import co.sixsu.app.material.domain.MatrecWaitVO;
import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.material.domain.SpAdjVO;
import co.sixsu.app.material.domain.SpDmgVO;
import co.sixsu.app.material.domain.SpShipVO;
import co.sixsu.app.material.domain.SpVO;
import co.sixsu.app.material.service.MaterialsService;


//자재관리
//곽호섭
@RequestMapping("/materials/")
@Controller
public class MaterialController {
	
	@Autowired MaterialsService service;
	@Autowired BasicService bservice;
//	
//	@GetMapping("/test")
//	public String test() {
//		return "/test";
//	}
	
	
	//발주관리 페이지 열어주기
	@GetMapping("matreq")
	public void matreqList(Model model) {
		model.addAttribute("REQSTAT",bservice.commGroupList("REQ_STAT"));
	}
	
	//자재입고관리 페이지 열어주기
	@GetMapping("matrec")
	public void matrecList() {
	}
	
	//자재Lot조회 페이지 열어주기
	@GetMapping("mlot")
	public void mlot() {
	}
	
	//자재조회 페이지 열어주기
	@GetMapping("materiallist")
	public void matList() {
	}
	
	//반제품 입고관리 페이지 열어주기
	@GetMapping("sprec")
	public void spRecList() {
	}
	
	//자재 출고조회 페이지 열어주기
	@GetMapping("matship")
	public void matShipList() {
	}
	
	//자재 재고조정 페이지 열어주기
	@GetMapping("matadj")
	public void matAdj() {
	}
	
	//반제품 재고조정 페이지 열어주기
	@GetMapping("spadj")
	public void spAdj() {
	}
	
	//반제품 리스트 페이지 열어주기
	@GetMapping("spship")
	public void spShipList() {
	}
	
	//반제품 반품/페기관리 페이지 열어주기
	@GetMapping("spdmg")
	public void spDmgList() {
	}
	
	//자재 반품/페기관리 페이지 열어주기
	@GetMapping("matdmg")
	public void matDmgList() {
	}
	
	//발주조회 페이지 열어주기
	@GetMapping("matreqlst")
	public void matReqList() {
	}
	
	//반제품 리스트 페이지 열어주기
	@GetMapping("splist")
	public void spList() {
	}
	
	//발주내역 리스트
	@ResponseBody
	@RequestMapping("matreqlist")
	public List<MatreqVO> getmatreqList(){
		List<MatreqVO> list = service.getMatReqList();
		return list;
	}
	
	
	//발주제거 컨트롤
	@ResponseBody
	@PostMapping("delmatreq")
	public void delMatReq(@RequestBody List<MatreqVO> vo) {
		System.out.println(vo);
		service.deleteMatReq(vo);
	}
	
	//발주등록 컨트롤
	@ResponseBody
	@PostMapping("insertmatreq")
	public MatreqVO insertMatReq(@RequestBody MatreqVO vo) {		
		System.out.println(vo);
		vo.setEmpId("12345");
		service.insertMatReq(vo);
		return vo;
		
	}
	
	//발주수정 컨트롤
	@ResponseBody
	@PostMapping("updatematreq")
	public void updateMatReq(@RequestBody List<MatreqVO> vo) {		
		service.updateMatReq(vo);
	}
	
	
	//입고대기 리스트 모달
	@ResponseBody
	@RequestMapping("matrecwait")
	public List<MatrecWaitVO> selectMatRecWaitList(){
		List<MatrecWaitVO> list = service.getMatRecWaitList();
		return list;
	}
	
	
	//입고 리스트
	@ResponseBody
	@RequestMapping("matreclist")
	public List<MatrecVO> selectMatRecList(){
		List<MatrecVO> list = service.getMatRecList();
		System.out.println(list);
		return list;
	}
	
	//입고등록
	@PostMapping("insertmatrec")
    @ResponseBody
    public void insertMatRec(@RequestBody List<MatrecVO> vo) {
		System.out.println(vo);
		service.insertMatRec(vo);
    }
	
	//자재 리스트
	@ResponseBody
	@RequestMapping("matlist")
	public List<MatVO> selectMatList(){
		List<MatVO> list = service.selectMatList();
		System.out.println(list);
		return list;
	}

	//입고 삭제 컨트롤
	@PostMapping("delmatrec")
    @ResponseBody
    public void delMatRec(@RequestBody List<MatrecVO> vo) {
		System.out.println(vo);
		service.delMatRec(vo);
		
	}
	
	//lot 리스트
	@ResponseBody
	@RequestMapping("matlotlist")
	public List<MatLotVO> mLotList(){
		List<MatLotVO> list = service.mLotList();
		return list;
	}
	
	//자재 출고 리스트
	@ResponseBody
	@RequestMapping("matshiplist")
	public List<MatShipVO> getMatShipList(){
		List<MatShipVO> list = service.getMatShipList();
		return list;
	}
	
	//자재 조정 리스트
	@ResponseBody
	@RequestMapping("matadjlist")
	public List<MatAdjVO> getMatAdjList(){
		List<MatAdjVO> list = service.getMatAdjList();
		return list;
	}
	
	//자재 조정 입고 컨트롤
	@PostMapping("matrecadj")
    @ResponseBody
    public void matRecAdj(@RequestBody List<MatAdjVO> vo) {
		System.out.println(vo);
		service.matRecAdj(vo);
		
	}
	
	//자재 조정 출고 컨트롤
	@PostMapping("matshipadj")
    @ResponseBody
    public void matShipAdj(@RequestBody List<MatAdjVO> vo) {
		System.out.println(vo);
		service.matShipAdj(vo);
	}
	
	//반제품 재고조정 리스트
	@ResponseBody
	@RequestMapping("spadjlist")
	public List<SpAdjVO> getSpAdjList(){
		List<SpAdjVO> list = service.getSpAdjList();
		return list;
	}
	

	//반제품 출고 리스트
	@ResponseBody
	@RequestMapping("spshiplist")
	public List<SpShipVO> getSpShipList(){
		List<SpShipVO> list = service.getSpShipList();
		return list;
	}
	
	//반제품 조정 입고 컨트롤
	@PostMapping("sprecadj")
    @ResponseBody
    public void spRecAdj(@RequestBody List<SpAdjVO> vo) {
		System.out.println(vo);
		service.spRecAdj(vo);
		
	}
	
	//반제품 조정 출고 컨트롤
	@PostMapping("spshipadj")
    @ResponseBody
    public void spShipAdj(@RequestBody List<SpAdjVO> vo) {
		System.out.println(vo);
		service.spShipAdj(vo);
	}
	
	//반제품 불량처리대기 리스트
	@ResponseBody
	@RequestMapping("spdmgwaitlist")
	public List<SpDmgVO> getSpDmgWaitList(){
		List<SpDmgVO> list = service.getSpDmgWaitList();
		return list;
	}
	
	//반제품 처리 리스트 
	@ResponseBody
	@RequestMapping("spdmglist")
	public List<SpDmgVO> getSpDmgList(){
		List<SpDmgVO> list = service.getSpDmgList();
		return list;
	}
	
	//반제품 불량처리
	@PostMapping("insertspdmg")
    @ResponseBody
    public void insertSpDmg(@RequestBody List<SpDmgVO> vo) {
		System.out.println("abc");
		System.out.println(vo);
		service.insertSpDmg(vo);
    }
	
	//자재 불량처리대기 리스트
	@ResponseBody
	@RequestMapping("matdmgwaitlist")
	public List<MatDmgVO> getMatDmgWaitList(){
		List<MatDmgVO> list = service.getMatDmgWaitList();
		return list;
	}
	
	//반제품 처리 리스트 
	@ResponseBody
	@RequestMapping("matdmglist")
	public List<MatDmgVO> getMatDmgList(){
		List<MatDmgVO> list = service.getMatDmgList();
		return list;
	}
	
	//자재 불량처리
	@PostMapping("insertmatdmg")
    @ResponseBody
    public void insertMatDmg(@RequestBody List<MatDmgVO> vo) {
		System.out.println("abc");
		System.out.println(vo);
		service.insertMatDmg(vo);
    }
	
	//반제품 리스트
	@ResponseBody
	@RequestMapping("semiprodlist")
	public List<SpVO> getSpList(){
		List<SpVO> list = service.getSpList();
		return list;
	}
}



