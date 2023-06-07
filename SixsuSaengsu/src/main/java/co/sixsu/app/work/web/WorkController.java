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
		return "work/viewPlanPage";
		}
		
		@GetMapping("/work/createPlanPage")
		public String createPlanPage() {
		return "work/createPlanPage";
		}
		@GetMapping("/work/viewWorkPage")
		public String viewWorkPage() {
			return "work/viewWorkPage";
		}
		@GetMapping("/work/workControllPage")
		public String workControllPage() {
		return "work/workControllPage";
		}
		
		@GetMapping("/work/createWorkPage")
		public String createWorkPage(Model model) {
			String orderCode = service.addWork();
			model.addAttribute("orderCode", orderCode);
		return "work/createWorkPage";
		}
		
		@GetMapping("/work/modifyWorkPage")
		public String modifyWorkPage(Model model, @RequestParam String data) {
			data = "20" + data.substring(0,data.lastIndexOf("-"));
			model.addAttribute("headCode",data);
			return "work/modifyWorkPage";
		}
		
		@GetMapping("/work/workKiosk")
		public String xPage() {
			return "/work/workKiosk";
		}
}



