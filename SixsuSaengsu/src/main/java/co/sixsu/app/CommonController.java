package co.sixsu.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
	@GetMapping("/login")
	public void login() { // 로그인 화면 불러오기
	}
	
	@GetMapping("/common/empManage")
	public void empManage() {
		
	}
	
}
