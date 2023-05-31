package co.sixsu.app.work.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.sixsu.app.work.service.WorkService;

@Controller
//@MapperScan(basePackages = "co.sixsu.app.**.mapper")
	public class WorkController {
	
		@Autowired WorkService service;
	
		@GetMapping("/work/viewPlanPage")
		public String viewPlanPage() {
			System.out.println("viewPlanPage 들어옴");
		return "/work/viewPlanPage";
		}
		
		@GetMapping("/work/createPlanPage")
		public String createPlanPage() {
			System.out.println("createPlanPage 들어옴");
		return "/work/createPlanPage";
		}
		@GetMapping("/work/viewWorkPage")
		public String viewWorkPage() {
			System.out.println("viewWorkPage 들어옴");
			return "/work/viewWorkPage";
		}
		@GetMapping("/work/workControllPage")
		public String workControllPage() {
			System.out.println("workControllPage 들어옴");
		return "/work/workControllPage";
		}
		
		@GetMapping("/work/createWorkPage")
		public String createWorkPage(Model model) {
			System.out.println("createWorkPage 들어옴");
			String orderCode = service.addWork();
			model.addAttribute("orderCode", orderCode);
		return "/work/createWorkPage";
		}
		
		@GetMapping("/work/modifyWorkPage")
		public String modifyWorkPage(Model model, @RequestParam String data) {
			System.out.println("modifyWorkPage 들어옴");
			System.out.println("SELECT CODE IS = " + data);
			data = "20" + data.substring(0,9);
			System.out.println("BEFORE DATA IS = " + data);
			model.addAttribute("headCode",data);
			return "/work/modifyWorkPage";
		}
		
		
		@GetMapping("/work/xPage")
		public String xPage(Model model) {
			System.out.println("xPage 들어옴");
		return "/work/xPage";
		}
}



