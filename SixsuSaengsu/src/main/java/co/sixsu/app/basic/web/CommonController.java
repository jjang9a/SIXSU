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
public class CommonController {
	@Autowired BasicService service;
	
	@GetMapping("/login")
	public void login() { // 로그인 화면 불러오기
	}
	
	@GetMapping("/common/empManage")
	public void empManage() { 	
	}
	
	@ResponseBody
	@RequestMapping("/common/empList")
	public List<EmpVO> empList(){
		List<EmpVO> list = service.getEmpList();
		//model.addAttribute("list", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/common/empAdd", method = RequestMethod.POST)
	public EmpVO empAdd(EmpVO emp) {
		//boolean result = service.empAdd(emp);
		/*
		 * rttr.addFlashAttribute("msg", "등록완료"); rttr.addAttribute("new", emp); return
		 * "redirect:common/empList";
		 */
		System.out.println("insert ajax >>>>");
		emp.setEmpStat("재직");
		String bir = emp.getEmpBirth();
		String pw = bir.substring(2, 4) + bir.substring(5,7) + bir.substring(8);
		emp.setEmpPw(pw);
		System.out.println(emp);
		boolean result = service.addEmp(emp);
		return emp;
	}
	
	@ResponseBody
	@PostMapping("/common/empPw")
	public boolean empPw(EmpVO emp, RedirectAttributes rttr) {
		System.out.println("password ajax >>>>>");
		System.out.println(emp);
		boolean result = service.updatePw(emp);
		System.out.println(result);
		return result;
	}
	
	
	
}
