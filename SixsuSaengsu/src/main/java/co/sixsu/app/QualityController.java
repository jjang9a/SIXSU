package co.sixsu.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import co.sixsu.app.domain.quality.ArrMatVO;
import co.sixsu.app.service.QualityService;

@Controller
//@SpringBootApplication
public class QualityController {
	
	@Autowired QualityService quaService;
	
	// 도착 자재 관리 페이지
	@GetMapping("quality/arr")
	public void arr() { 
	}
	
	// 도착 자재 리스트
	@ResponseBody
	@RequestMapping("quality/arrList")
	public List<ArrMatVO> arrList(Model model) {
		List<ArrMatVO> list = quaService.getArrList();
		model.addAttribute("arrList", list);
		return list;
	}
	
	// 자재 도착 등록 대기 리스트
	@ResponseBody
	@RequestMapping("quality/arrRegList")
	public List<ArrMatVO> arrRegList(Model model){
		List<ArrMatVO> rList = quaService.arrRegList();
		model.addAttribute("regList", rList);
		return rList;
	}
	
	// 도착 등록
	@ResponseBody
	@PostMapping("quality/arrRegister")
	public String arrRegister(ArrMatVO am, RedirectAttributes rttr) {
		
		quaService.addArr(am);
		System.out.println(am);
		return "redirect:/quality/arr";
	}
	

}
