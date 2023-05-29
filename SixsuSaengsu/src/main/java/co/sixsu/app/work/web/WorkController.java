package co.sixsu.app.work.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.sixsu.app.work.service.WorkService;

@Controller
//@MapperScan(basePackages = "co.sixsu.app.**.mapper")
	public class WorkController {
	
		@Autowired WorkService service;
	
		@GetMapping("/work/viewPlanPage")
		public String work1() {
			System.out.println("viewPlanPage 들어옴");
		return "/work/viewPlanPage";
		}
		
		@GetMapping("/work/createPlanPage")
		public String work3() {
			System.out.println("createPlanPage 들어옴");
		return "/work/createPlanPage";
		}
		@GetMapping("/work/viewWorkPage")
		public String work2() {
			System.out.println("viewWorkPage 들어옴");
			return "/work/viewWorkPage";
		}
		
		@GetMapping("/work/createWorkPage")
		public String work4(Model model) {
			System.out.println("createWorkPage 들어옴");
			String orderCode = service.addWork();
			model.addAttribute("orderCode", orderCode);
		return "/work/createWorkPage";
		}
		
		@GetMapping("/work/xPage")
		public String work5(Model model) {
			System.out.println("xPage 들어옴");
		return "/work/xPage";
		}
}



