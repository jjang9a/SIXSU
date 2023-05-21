package co.sixsu.app.basic.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.sixsu.app.basic.domain.CodeVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.basic.domain.SearchDTO;
import co.sixsu.app.basic.service.BasicService;
import co.sixsu.app.sales.domain.OrdVO;

@Controller
public class BasicController {
	@Autowired BasicService service;
	
	@GetMapping("/login")
	public void login() { // 로그인 화면 화면 띄우기
	}
	
	
	// 사원관리
	
	@GetMapping("/basic/empManage")
	public void empManage() { 	// 사원관리 화면 띄우기
	}
	
	@ResponseBody
	@RequestMapping("/basic/empList") // 사원정보 목록 ajax
	public List<EmpVO> empList(){ 
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
	public List<CodeVO> groupList(){
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
	public List<ProductVO> cpList(){ //완제품 목록
		return service.cpList();
	}
	
	@ResponseBody
	@PostMapping("/basic/addCp")
	public ProductVO addCp(ProductVO prod) {
		System.out.println(prod);
		service.addCp(prod);
		return prod;
	}
	
	@ResponseBody
	@PostMapping("/basic/modifyCp")
	public ProductVO modifyCp(ProductVO prod) {
		service.updateCp(prod);
		return prod;
	}
	

	
}
