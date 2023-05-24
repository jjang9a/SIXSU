package co.sixsu.app.work.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import co.sixsu.app.work.service.WorkService;

@Controller
//@MapperScan(basePackages = "co.sixsu.app.**.mapper")
	public class WorkController {
	
		@Autowired WorkService service;
	
		@GetMapping("work1")
		public String work1() {
			System.out.println("work1 들어옴");
		return "/work/work1";
		}
		
		@GetMapping("work2")
		public String work2() {
			System.out.println("work2 들어옴");
		return "/work/work2";
		}
		
		@GetMapping("work3")
		public String work3() {
			System.out.println("work3 들어옴");
		return "/work/work3";
		}
		
		@GetMapping("work4")
		public String work4(Model model) {
			System.out.println("work4 들어옴");
			String orderCode = service.addWork();
			model.addAttribute("orderCode", orderCode);
		return "/work/work4";
		}
		
		
		
}



