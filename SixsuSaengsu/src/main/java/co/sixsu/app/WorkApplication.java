package co.sixsu.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
//@MapperScan(basePackages = "co.sixsu.app.**.mapper")
	public class WorkApplication {
	
		@GetMapping("work1")
		public String test1() {
			System.out.println("test1 들어옴");
		return "/work/test1";
		}
		
		@GetMapping("work2")
		public String test2() {
			System.out.println("test2 들어옴");
		return "/work/test2";
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
		
		@RequestMapping("toastDataList")
		public List toastDataList() {
			List list = new ArrayList();
			Data data = new Data("a", "b", "c", "1.1.1.0","M");
			list.add(data);
			return list;
		}
}



