package co.sixsu.app.domain.material.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.domain.material.MatreqVO;
import co.sixsu.app.mapper.MaterialsMapper;

@Controller
public class MatreqController {
	
	@Autowired MaterialsMapper mapper;
//	
//	@GetMapping("/test")
//	public String test() {
//		return "/test";
//	}
	
	@RequestMapping("/materials/matreq")
	public String empList(Model model){
		model.addAttribute("matreqList", mapper.getMatRecList());
		return "matreq";
	}
	
	@GetMapping("/materials/mm")
	public String mm() {
		return"/materials/mm";
	}
	
	
	@ResponseBody
	@RequestMapping("/materials/mms")
	public List<MatreqVO> mm(Model modal){
		List<MatreqVO> list = mapper.getMatRecList();
		modal.addAttribute("list", list);
		return list;
	}
}
