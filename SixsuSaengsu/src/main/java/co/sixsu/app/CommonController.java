package co.sixsu.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
}
