package co.sixsu.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.domain.quality.ArrMatVO;
import co.sixsu.app.service.QualityService;

@Controller
//@SpringBootApplication
public class QualityController {
	
	@Autowired QualityService quaService;
	
	
	@GetMapping("quality/arr")
	public void arr() { // 도착 자재 관리
	}
	
	@RequestMapping("quality/arrList")
	@ResponseBody
	public void arrList(Model model) {
		List<ArrMatVO> list = quaService.getArrList();
		model.addAttribute("arrList", list);
	}

}
