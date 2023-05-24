package co.sixsu.app.basic.web;

import java.util.List;

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
import co.sixsu.app.basic.domain.MaterialVO;
import co.sixsu.app.basic.domain.ProcessVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.basic.domain.SearchDTO;
import co.sixsu.app.basic.service.BasicService;

@Controller
public class BasicController {
	@Autowired
	BasicService service;

	@GetMapping("/login")
	public void login() { // 로그인 화면 화면 띄우기
	}

	// 사원관리

	@GetMapping("/basic/empManage")
	public void empManage() { // 사원관리 화면 띄우기
	}

	@ResponseBody
	@RequestMapping("/basic/empList") // 사원정보 목록 ajax
	public List<EmpVO> empList() {
		List<EmpVO> list = service.getEmpList();
		return list;
	}

	@ResponseBody // 사원 등록 ajax
	@RequestMapping(value = "/basic/empAdd", method = RequestMethod.POST)
	public EmpVO empAdd(EmpVO emp) {
		EmpVO result = service.addEmp(emp);
		return result;
	}

	@ResponseBody
	@PostMapping("/basic/empPw") // 사원 비밀번호 변경 ajax
	public boolean empPw(EmpVO emp, RedirectAttributes rttr) {
		boolean result = service.updatePw(emp);
		return result;
	}

	@ResponseBody
	@PostMapping("/basic/empModify") // 사원정보 수정 ajax
	public String empModify(@RequestBody EmpVO emp) {
		service.updateEmp(emp);
		return "result";
	}

	// 공통코드

	@GetMapping("/basic/codeManage")
	public void codeManage() { // 공통코드 화면 띄우기
	}

	@ResponseBody
	@GetMapping("/basic/groupList")
	public List<CodeVO> groupList() {
		List<CodeVO> glist = service.groupList();
		return glist;
	}

	@ResponseBody
	@RequestMapping("/basic/commList") // 선택, 검색 기반 공통코드 조회
	public List<CodeVO> commList(SearchDTO dto) {
		List<CodeVO> clist = service.commList(dto);
		return clist;
	}

	@ResponseBody
	@PostMapping("/basic/addCode") // 공통코드 등록
	public boolean addCode(@RequestBody List<CodeVO> list) {
		return service.addCode(list);
	}

	@ResponseBody
	@PostMapping("/basic/modifyCode") // 공통코드 수정
	public boolean modifyCode(@RequestBody List<CodeVO> list) {
		return service.updateCode(list);
	}

	// 완제품 관리

	@GetMapping("/basic/cpManage")
	public void cpManage() { // 완제품 관리 화면 띄우기
	}

	@ResponseBody
	@GetMapping("/basic/cpList")
	public List<ProductVO> cpList() { // 완제품 목록
		return service.cpList();
	}

	@ResponseBody
	@PostMapping("/basic/addCp")
	public ProductVO addCp(ProductVO prod) {
		service.addCp(prod);
		return prod;
	}

	@ResponseBody
	@PostMapping("/basic/modifyCp")
	public ProductVO modifyCp(ProductVO prod) {
		service.updateCp(prod);
		return prod;
	}

	@ResponseBody
	@GetMapping("/basic/searchCp") // 선택, 검색 기반 공통코드 조회
	public List<ProductVO> searchCp(SearchDTO dto) {
		return service.searchCp(dto);
	}

	// 반제품 관리

	@GetMapping("/basic/spManage")
	public void spManage() { // 반제품 관리 화면 띄우기
	}

	@ResponseBody
	@GetMapping("/basic/spList")
	public List<ProductVO> spList() { // 반제품 목록
		return service.spList();
	}

	@ResponseBody
	@PostMapping("/basic/addSp")
	public ProductVO addSp(ProductVO prod) { // 반제품 등록
		service.addSp(prod);
		return prod;
	}

	@ResponseBody
	@PostMapping("/basic/modifySp")
	public ProductVO modifySp(ProductVO prod) { // 반제품 수정
		service.updateSp(prod);
		return prod;
	}

	@ResponseBody
	@GetMapping("/basic/searchSp") // 반제품 검색
	public List<ProductVO> searchSp(SearchDTO dto) {
		return service.searchSp(dto);
	}

	// 자재 관리

	@GetMapping("/basic/matManage")
	public void matManage() { // 자재 관리 화면 띄우기
	}

	@ResponseBody
	@GetMapping("/basic/matList")
	public List<MaterialVO> matList() { // 자재 목록
		return service.matList();
	}

	@ResponseBody
	@PostMapping("/basic/addMat")
	public MaterialVO addMat(MaterialVO mat) { // 자재 등록
		service.addMat(mat);
		return mat;
	}

	@ResponseBody
	@PostMapping("/basic/modifyMat")
	public MaterialVO modifyMat(MaterialVO mat) { // 자재 수정
		service.updateMat(mat);
		return mat;
	}

	@ResponseBody
	@GetMapping("/basic/searchMat") // 자재 검색
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
	@GetMapping("/basic/procList")
	public List<ProcessVO> procList() { // 공정 목록
		return service.procList();
	}

	@ResponseBody
	@PostMapping("/basic/addProc")
	public ProcessVO addProc(ProcessVO prod) {
		service.addProc(prod);
		return prod;
	}

	@ResponseBody
	@PostMapping("/basic/modifyProc")
	public ProcessVO modifyProc(ProcessVO prod) {
		service.updateProc(prod);
		return prod;
	}

	@ResponseBody
	@GetMapping("/basic/searchProc") // 선택, 검색 기반 공통코드 조회
	public List<ProcessVO> searchProc(SearchDTO dto) {
		return service.searchProc(dto);
	}
	
	// 거래처 관리

	@GetMapping("/basic/businessManage")
	public void businessManage() { // 거래처 관리 화면 띄우기
	}

	@ResponseBody
	@GetMapping("/basic/checkBusNum") // 사업자번호 중복 조회
	public boolean checkBusNum(@RequestParam String busNum) {
		return service.checkBusNum(busNum);
	}

	@ResponseBody
	@GetMapping("/basic/busList")
	public List<BusVO> busList() { // 거래처 목록
		return service.busList();
	}


	@ResponseBody
	@PostMapping("/basic/addBus")
	public BusVO addBus(BusVO bus) { // 거래처 등록
		service.addBus(bus); 
		return bus; 
	}


	@ResponseBody
	@PostMapping("/basic/modifyBus")
	public BusVO modifyBus(BusVO bus) { // 거래처 수정
		service.updateBus(bus);
		return bus;
	}

	@ResponseBody
	@GetMapping("/basic/searchBus") // 거래처 검색
	public List<BusVO> searchBus(SearchDTO dto) {
		System.out.println(dto);
		return service.searchBus(dto);
	}
	
	
	// 제품 BOM
	@GetMapping("/basic/bomManage")
	public void bodManage() {
	}
	
	@ResponseBody
	@GetMapping("/basic/bomList")
	public List<BomVO> bomList(@RequestParam String id) { // 거래처 목록
		return service.bomList(id);
	}

	@ResponseBody
	@GetMapping("/basic/activeCpList")
	public List<ProductVO> activeCpList() { // 활성화된 완제품 목록
		return service.activeCpList();
	}
	
	@ResponseBody
	@GetMapping("/basic/activeSpList")
	public List<ProductVO> activeSpList() { // 활성화된 반제품 목록
		return service.activeSpList();
	}
	
	@ResponseBody
	@PostMapping("/basic/addBom") // BOM 등록
	public boolean addBom(@RequestBody List<BomVO> list) {
		return service.addBom(list);
	}

	@ResponseBody
	@PostMapping("/basic/modifyBom") // BOM 수정
	public boolean modifyBom(@RequestBody List<BomVO> list) {
		return service.updateBom(list);
	}
	
	
}
