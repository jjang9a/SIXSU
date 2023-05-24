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
	
		@GetMapping("work1")
		public String work1() {
			System.out.println("test1 들어옴");
		return "/work/work1";
		}
		
		@GetMapping("work2")
		public String work2() {
			System.out.println("test2 들어옴");
		return "/work/work2";
		}
		
		@GetMapping("work3")
		public String work3() {
			System.out.println("test3 들어옴");
		return "/work/work3";
		}
		
		@GetMapping("work4")
		public String work4(Model model) {
			System.out.println("work4 들어옴");
			String orderCode = service.addWork();
			model.addAttribute("orderCode", orderCode);
		return "/work/work4";
		}
		
		
		@RequestMapping("toastList")
		public List toastList() {
			System.out.println("ajax 들어오긴 했음");
			List list = new ArrayList();
			Map map = new HashMap();
			map.put("name",  "a");
			map.put("artist",  "b");
			map.put("type",  "c");
			map.put("release",  "1.1.1.0");
			map.put("genre",  "M");
			list.add(map);
			return list;
		}
		
}



