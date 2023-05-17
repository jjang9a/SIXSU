package co.sixsu.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.sixsu.app.domain.common.EmpVO;
import co.sixsu.app.service.CommonService;

@Controller
public class CommonController {
	@Autowired CommonService service;
	
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
	public void empAdd(EmpVO emp, RedirectAttributes rttr) {
		//boolean result = service.empAdd(emp);
		/*
		 * rttr.addFlashAttribute("msg", "등록완료"); rttr.addAttribute("new", emp); return
		 * "redirect:common/empList";
		 */
		System.out.println("insert ajax >>>>");
		System.out.println(emp);
	}
	
	
}
