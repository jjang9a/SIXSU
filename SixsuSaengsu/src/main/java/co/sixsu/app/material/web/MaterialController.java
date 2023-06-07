package co.sixsu.app.material.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.basic.domain.BusVO;
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
import co.sixsu.app.material.domain.SpLotVO;
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
	
	//자재입고조회 페이지 열어주기
	@GetMapping("matRecInfo")
	public void matRecInfo() {
	}
	
	//자재Lot조회 페이지 열어주기
	@GetMapping("matLotInfo")
	public void mlot() {
	}
	
	//자재조회 페이지 열어주기
	@GetMapping("matInfo")
	public void matList() {
	}
	
	//반제품 입고관리 페이지 열어주기
	@GetMapping("sprec")
	public void spRecList() {
	}
	
	//자재 출고조회 페이지 열어주기
	@GetMapping("matShipInfo")
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
	@GetMapping("spShipInfo")
	public void spShipList() {
	}
	
	//자재 불량 페이지 열어주기
	@GetMapping("matdmg")
	public void matDmgList() {
	}
	
	//발주조회 페이지 열어주기
	@GetMapping("matReqInfo")
	public void matReqList(Model model) {
		model.addAttribute("REQSTAT",bservice.commGroupList("REQ_STAT"));
	}
	
	//반제품 리스트 페이지 열어주기
	@GetMapping("spInfo")
	public void spList() {
	}
	
	//반제품 LOT 리스트 페이지 열어주기
	@GetMapping("spLotInfo")
	public void spLotList() {
	}
	
	
	//발주내역 리스트
	@ResponseBody
	@RequestMapping("matreqlist")
	public List<MatreqVO> getmatreqList(){
		List<MatreqVO> list = service.getMatReqList();
		return list;
	}
	
	//발주조회 컨트롤
	@ResponseBody
	@RequestMapping("matreqsearch")
	public List<MatreqVO> getMatReqSearch(MatreqVO vo){
		List<MatreqVO> list = service.getMatReqSearch(vo);
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
	public MatreqVO insertMatReq(@RequestBody MatreqVO vo, Principal principal) {		
		System.out.println(vo);
		String id = principal.getName();
		vo.setEmpId(id);
		System.out.println(id);
		service.insertMatReq(vo);
		return vo;
		
	}
	
	//발주수정 컨트롤
	@ResponseBody
	@PostMapping("updatematreq")
	public void updateMatReq(@RequestBody List<MatreqVO> vo) {		
		service.updateMatReq(vo);
	}
	
	//발주 거래처 리스트
	@ResponseBody
	@RequestMapping("matreqbuslist")
	public List<BusVO> matReqBusList(){
		List<BusVO> list = service.matReqBusList();
		return list;
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
	
	//입고 리스트
	@ResponseBody
	@RequestMapping("matrecsearch")
	public List<MatrecVO> getMatRecSearch(MatrecVO vo){
		List<MatrecVO> list = service.getMatRecSearch(vo);
		return list;
	}
	
	//입고등록
	@PostMapping("insertmatrec")
    @ResponseBody
    public void insertMatRec(@RequestBody List<MatrecVO> vo, Principal principal) {
		System.out.println(vo);
		vo.get(0).setEmpId(principal.getName()); // 로그인 아이디 가져오기
		service.insertMatRec(vo);
    }
	
	//자재 리스트
	@ResponseBody
	@RequestMapping("matlist")
	public List<MatVO> selectMatList(MatVO vo){
		System.err.println(vo);
		List<MatVO> list = service.selectMatList(vo);
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
	
	//자재 lot 리스트
	@ResponseBody
	@RequestMapping("matlotlist")
	public List<MatLotVO> mLotList(MatLotVO vo){
		System.err.println(vo);
		List<MatLotVO> list = service.mLotList(vo);
		return list;
	}
	
	//자재 출고 리스트
	@ResponseBody
	@RequestMapping("matshiplist")
	public List<MatShipVO> getMatShipList(MatShipVO vo){
		List<MatShipVO> list = service.getMatShipList(vo);
		return list;
	}
	
	//자재 조정 리스트
	@ResponseBody
	@RequestMapping("matadjlist")
	public List<MatAdjVO> getMatAdjList(@RequestParam String matLotId){
		List<MatAdjVO> list = service.getMatAdjList(matLotId);
		System.out.println(list);
		return list;
	}
	
	//자재 조정 입고 컨트롤
	@PostMapping("matrecadj")
    @ResponseBody
    public void matRecAdj(@RequestBody List<MatAdjVO> vo, Principal principal) {
		vo.get(0).setEmpId(principal.getName());
		System.out.println(vo);
		service.matRecAdj(vo);
		
	}
	
	//자재 조정 출고 컨트롤
	@PostMapping("matshipadj")
    @ResponseBody
    public void matShipAdj(@RequestBody List<MatAdjVO> vo, Principal principal) {
		vo.get(0).setEmpId(principal.getName());
		System.out.println(vo);
		service.matShipAdj(vo);
	}
	
	//반제품 재고조정 리스트
	@ResponseBody
	@RequestMapping("spadjlist")
	public List<SpAdjVO> getSpAdjList(String spLotId){
		List<SpAdjVO> list = service.getSpAdjList(spLotId);
		return list;
	}
	

	//반제품 출고 리스트
	@ResponseBody
	@RequestMapping("spshiplist")
	public List<SpShipVO> getSpShipList(SpShipVO vo){
		List<SpShipVO> list = service.getSpShipList(vo);
		return list;
	}
	
	//반제품 조정 입고 컨트롤
	@PostMapping("sprecadj")
    @ResponseBody
    public void spRecAdj(@RequestBody List<SpAdjVO> vo, Principal principal) {
		vo.get(0).setEmpId(principal.getName());
		System.out.println(vo);
		service.spRecAdj(vo);
		
	}
	
	//반제품 조정 출고 컨트롤
	@PostMapping("spshipadj")
    @ResponseBody
    public void spShipAdj(@RequestBody List<SpAdjVO> vo, Principal principal) {
		vo.get(0).setEmpId(principal.getName());
		System.out.println(vo);
		service.spShipAdj(vo);
	}
	
	//반제품 리스트
	@ResponseBody
	@RequestMapping("semiprodlist")
	public List<SpVO> getSpList(@RequestParam String spName){
		List<SpVO> list = service.getSpList(spName);
		return list;
	}
	
	//불량품 처리대기 리스트
	@ResponseBody
	@RequestMapping("matdmgwaitlist")
	public List<MatDmgVO> getMatDmgWaitList(){
		List<MatDmgVO> list = service.getMatDmgWaitList();
		return list;
	}
	
	//불량품 리스트
	@ResponseBody
	@RequestMapping("matdmglist")
	public List<MatDmgVO> getMatDmgList(){
		List<MatDmgVO> list = service.getMatDmgList();
		return list;
	}
	

	 //자재 불량처리
	 @PostMapping("insertMatDmg")
	 @ResponseBody 
	 public void insertMatDmg2(@RequestBody List<MatDmgVO> vo, Principal principal) {
		 vo.get(0).setEmpId(principal.getName()); // 로그인 아이디 가져오기
		 service.insertMatDmg(vo);
	 }
	 
	//반제품 LOT 리스트
	@ResponseBody
	@RequestMapping("splotlist")
	public List<SpLotVO> getSpLotList(SpLotVO vo){
		List<SpLotVO> list = service.getSpLotList(vo);
		return list;
	}
	 
}



