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
	
	@ResponseBody
	@RequestMapping("quality/arrList")
	public List<ArrMatVO> arrList(Model model) {
		List<ArrMatVO> list = quaService.getArrList();
		model.addAttribute("arrList", list);
		return list;
	}
	
	@GetMapping("quality/arrMat")
	public String arrMat() {
		return "quality/arrMat";
	}
	
	
	@ResponseBody
	@RequestMapping("quality/arrRegList")
	public List<ArrMatVO> arrRegList(Model model){
		List<ArrMatVO> rList = quaService.arrRegList();
		model.addAttribute("regList", rList);
		return rList;
	}
	

}
