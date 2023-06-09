package co.sixsu.app.basic.web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.sixsu.app.basic.domain.BomVO;
import co.sixsu.app.basic.domain.BusVO;
import co.sixsu.app.basic.domain.CodeVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.FlowVO;
import co.sixsu.app.basic.domain.MaterialVO;
import co.sixsu.app.basic.domain.ProcessVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.basic.domain.SearchDTO;
import co.sixsu.app.basic.service.BasicService;
import co.sixsu.app.sales.domain.GridDataVO;

@Controller
public class BasicController {
	@Autowired
	BasicService service;
	
	@GetMapping("/login")
	public void login(Principal principal, HttpServletRequest request) { // 로그인 화면 화면 띄우기
//		return request.getContextPath()
		
	}

	// 사원관리

	@GetMapping("/basic/empManage")
	public void empManage() { // 사원관리 화면 띄우기
	}

	@ResponseBody
	@RequestMapping("/basic/empList.Ajax") // 사원정보 목록 ajax
	public List<EmpVO> empList() {
		List<EmpVO> list = service.getEmpList();
		return list;
	}

	@ResponseBody // 사원 등록 ajax
	@RequestMapping(value = "/basic/empAdd.Ajax", method = RequestMethod.POST)
	public EmpVO empAdd(EmpVO emp) {
		EmpVO result = service.addEmp(emp);
		return result;
	}

	@ResponseBody
	@PostMapping("/basic/empPw.Ajax") // 사원 비밀번호 변경 ajax
	public boolean empPw(EmpVO emp, RedirectAttributes rttr) {
		boolean result = service.updatePw(emp);
		return result;
	}

	@ResponseBody
	@PostMapping("/basic/empModify.Ajax") // 사원정보 수정 ajax
	public boolean empModify(@RequestBody List<EmpVO> emp) {
		System.out.println(emp);
		service.updateEmp(emp);
		return true;
	}
	
	@ResponseBody
	@GetMapping("/basic/searchEmp.Ajax") // 사원 조회
	public List<EmpVO> searchEmp(SearchDTO dto) {
		return service.searchEmp(dto);
	}

	// 공통코드

	@GetMapping("/basic/codeManage")
	public void codeManage() { // 공통코드 화면 띄우기
	}

	@ResponseBody
	@GetMapping("/basic/groupList.Ajax")
	public List<CodeVO> groupList() { // 그룹 리스트
		List<CodeVO> glist = service.groupList();
		return glist;
	}

	@ResponseBody
	@RequestMapping("/basic/commList.Ajax") // 선택, 검색 기반 공통코드 조회
	public List<CodeVO> commList(SearchDTO dto) {
		List<CodeVO> clist = service.commList(dto);
		return clist;
	}

	@ResponseBody
	@PostMapping("/basic/modifyCode.Ajax") // 공통코드 등록, 수정
	public boolean modifyCode(@RequestBody GridDataVO<CodeVO> list) {
		return service.updateCode(list);
	}
	
	@ResponseBody
	@PostMapping("/basic/addGroup.Ajax") // 그룹 등록
	public CodeVO addGroup(CodeVO code) {
		service.addGroup(code);
		return code;
	}

	// 완제품 관리

	@GetMapping("/basic/cpManage")
	public void cpManage(Model model) { // 완제품 관리 화면 띄우기
		String key = "cp_size";
		model.addAttribute("types", service.getComList(key));
	}

	@ResponseBody
	@GetMapping("/basic/cpList.Ajax")
	public List<ProductVO> cpList() { // 완제품 목록
		return service.cpList();
	}

	@ResponseBody
	@PostMapping("/basic/addCp.Ajax")
	public ProductVO addCp(ProductVO prod) {
		service.addCp(prod);
		return prod;
	}

	@ResponseBody
	@PostMapping("/basic/modifyCp.Ajax")
	public ProductVO modifyCp(ProductVO prod) {
		service.updateCp(prod);
		return prod;
	}

	@ResponseBody
	@GetMapping("/basic/searchCp.Ajax") // 선택, 검색 기반 공통코드 조회
	public List<ProductVO> searchCp(SearchDTO dto) {
		return service.searchCp(dto);
	}

	// 반제품 관리

	@GetMapping("/basic/spManage")
	public void spManage() { // 반제품 관리 화면 띄우기
	}

	@ResponseBody
	@GetMapping("/basic/spList.Ajax")
	public List<ProductVO> spList() { // 반제품 목록
		return service.spList();
	}

	@ResponseBody
	@PostMapping("/basic/addSp.Ajax")
	public ProductVO addSp(ProductVO prod) { // 반제품 등록
		service.addSp(prod);
		return prod;
	}

	@ResponseBody
	@PostMapping("/basic/modifySp.Ajax")
	public ProductVO modifySp(ProductVO prod) { // 반제품 수정
		service.updateSp(prod);
		return prod;
	}

	@ResponseBody
	@GetMapping("/basic/searchSp.Ajax") // 반제품 검색
	public List<ProductVO> searchSp(SearchDTO dto) {
		return service.searchSp(dto);
	}

	// 자재 관리

	@GetMapping("/basic/matManage")
	public void matManage() { // 자재 관리 화면 띄우기
	}

	@ResponseBody
	@GetMapping("/basic/matList.Ajax")
	public List<MaterialVO> matList() { // 자재 목록
		return service.matList();
	}

	@ResponseBody
	@PostMapping("/basic/addMat.Ajax")
	public MaterialVO addMat(MaterialVO mat) { // 자재 등록
		service.addMat(mat);
		return mat;
	}

	@ResponseBody
	@PostMapping("/basic/modifyMat.Ajax")
	public MaterialVO modifyMat(MaterialVO mat) { // 자재 수정
		service.updateMat(mat);
		return mat;
	}

	@ResponseBody
	@GetMapping("/basic/searchMat.Ajax") // 자재 검색
	public List<MaterialVO> searchMat(SearchDTO dto) {
		return service.searchMat(dto);
	}

	// 공정 관리

	@GetMapping("/basic/procManage")
	public void procManage(Model model) { // 공정 관리 화면 띄우기
		String key = "proc_type";
		model.addAttribute("types", service.getComList(key));
	}
	
	@ResponseBody
	@GetMapping("/basic/procList.Ajax")
	public List<ProcessVO> procList() { // 공정 목록
		return service.procList();
	}

	@ResponseBody
	@PostMapping("/basic/addProc.Ajax")
	public ProcessVO addProc(ProcessVO prod) {
		service.addProc(prod);
		return prod;
	}

	@ResponseBody
	@PostMapping("/basic/modifyProc.Ajax")
	public ProcessVO modifyProc(ProcessVO prod) {
		service.updateProc(prod);
		return prod;
	}

	@ResponseBody
	@GetMapping("/basic/searchProc.Ajax") // 선택, 검색 기반 공통코드 조회
	public List<ProcessVO> searchProc(SearchDTO dto) {
		return service.searchProc(dto);
	}
	
	// 거래처 관리

	@GetMapping("/basic/businessManage")
	public void businessManage(Model model) { // 거래처 관리 화면 띄우기
		String key = "BUS_TYPE";
		model.addAttribute("types", service.getComList(key));
	}

	@ResponseBody
	@GetMapping("/basic/checkBusNum.Ajax") // 사업자번호 중복 조회
	public boolean checkBusNum(@RequestParam String busNum) {
		return service.checkBusNum(busNum);
	}

	@ResponseBody
	@GetMapping("/basic/busList.Ajax")
	public List<BusVO> busList() { // 거래처 목록
		return service.busList();
	}


	@ResponseBody
	@PostMapping("/basic/addBus.Ajax")
	public BusVO addBus(BusVO bus) { // 거래처 등록
		service.addBus(bus); 
		return bus; 
	}


	@ResponseBody
	@PostMapping("/basic/modifyBus.Ajax")
	public BusVO modifyBus(BusVO bus) { // 거래처 수정
		service.updateBus(bus);
		return bus;
	}

	@ResponseBody
	@PostMapping("/basic/searchBus.Ajax") // 거래처 검색
	public List<BusVO> searchBus(BusVO bus) {
		return service.searchBus(bus);
	}
	
	
	// 제품 BOM
	@GetMapping("/basic/bomManage")
	public void bodManage() {
	}
	
	@ResponseBody
	@GetMapping("/basic/bomList.Ajax")
	public List<BomVO> bomList(@RequestParam String id) { // BOM 목록
		return service.bomList(id);
	}

	@ResponseBody
	@GetMapping("/basic/activeCpList.Ajax")
	public List<ProductVO> activeCpList() { // 활성화된 완제품 목록
		return service.activeCpList();
	}
	
	@ResponseBody
	@GetMapping("/basic/activeSpList.Ajax")
	public List<ProductVO> activeSpList() { // 활성화된 반제품 목록
		return service.activeSpList();
	}
	
	@ResponseBody
	@GetMapping("/basic/activeMatList.Ajax")
	public List<ProductVO> activeMatList() { // 활성화된 자재 목록
		return service.activeMaterialList();
	}
	
	@ResponseBody
	@GetMapping("/basic/activeProcList.Ajax")
	public List<ProcessVO> activeProcList() { // 활성화된 공정 목록
		return service.activeProcList();
	}
	
	@ResponseBody
	@PostMapping("/basic/addBom.Ajax") // BOM 등록
	public boolean addBom(@RequestBody List<BomVO> list) {
		return service.addBom(list);
	}

	@ResponseBody
	@PostMapping("/basic/modifyBom.Ajax") // BOM 수정
	public boolean modifyBom(@RequestBody GridDataVO<BomVO> list) {
		return service.updateBom(list);
	}
	
	@ResponseBody
	@PostMapping("/basic/deleteBom.Ajax") // BOM 수정
	public boolean deleteBom(@RequestBody List<BomVO> list) {
		return service.deleteBom(list);
	}
	
	
	// 제품 공정흐름도
	
	@GetMapping("/basic/flowManage")
	public void flowManage() { // 공정흐름도 관리 페이지 띄우기
	}
	
	@ResponseBody
	@GetMapping("/basic/flowList.Ajax") // 제품별 공정흐름도
	public List<FlowVO> flowList(@RequestParam String id){
		return service.flowList(id);
	}

	@ResponseBody
	@PostMapping("/basic/modifyFlow.Ajax") // 제품공정 등록, 수정, 삭제
	public boolean modifyFlow(@RequestBody GridDataVO<FlowVO> list) {
		return service.updateFlow(list);
	}

	
}
