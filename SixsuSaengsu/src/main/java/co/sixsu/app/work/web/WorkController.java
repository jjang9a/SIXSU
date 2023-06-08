package co.sixsu.app.work.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.sixsu.app.work.service.WorkService;

@Controller
@RequestMapping("/work/")
	public class WorkController {
	
		@Autowired WorkService service;
	
		@GetMapping("viewPlanInfo")
		public String viewPlanPage() {
		return "work/viewPlanInfo";
		}
		
		@GetMapping("createPlanPage")
		public String createPlanPage() {
		return "work/createPlanPage";
		}
		@GetMapping("viewWorkInfo")
		public String viewWorkPage() {
			return "work/viewWorkInfo";
		}
		@GetMapping("workControllPage")
		public String workControllPage() {
		return "work/workControllPage";
		}
		
		@GetMapping("createWorkPage")
		public String createWorkPage(Model model) {
			String orderCode = service.addWork();
			model.addAttribute("orderCode", orderCode);
		return "work/createWorkPage";
		}
		
		@GetMapping("modifyWorkPage")
		public String modifyWorkPage(Model model, @RequestParam String data) {
			data = "20" + data.substring(0,data.lastIndexOf("-"));
			model.addAttribute("headCode",data);
			return "work/modifyWorkPage";
		}
		
		@GetMapping("workKiosk")
		public String workKiosk() {
			return "work/workKiosk";
		}
}



