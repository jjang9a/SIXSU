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

import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.service.BasicService;

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
		emp.setEmpStat("재직");
		String bir = emp.getEmpBirth();
		String pw = bir.substring(2, 4) + bir.substring(5,7) + bir.substring(8);
		emp.setEmpPw(pw);
		service.addEmp(emp);
		return emp;
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
		System.out.println(emp);
		service.updateEmp(emp);
		return "result";
	}
	
	
	// 공통코드
	
	@GetMapping("/basic/codeManage")
	public void codeManage() { // 공통코드 화면 띄우기
	}
	
	
	
	
}
