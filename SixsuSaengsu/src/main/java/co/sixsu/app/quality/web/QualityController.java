package co.sixsu.app.quality.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.quality.domain.QuaVO;
import co.sixsu.app.quality.service.QualityService;

@Controller
//@SpringBootApplication
public class QualityController {
	
	@Autowired QualityService quaService;
	
	// 도착 자재 관리 페이지
	@GetMapping("/quality/arr")
	public void arr() { 
	}
	
	// 도착 자재 리스트
	@ResponseBody
	@RequestMapping("/quality/arrList")
	public List<QuaVO> arrList(Model model) {
		List<QuaVO> list = quaService.getArrList();
		model.addAttribute("arrList", list);
		return list;
	}
	
	// 자재 도착 등록 대기 리스트
	@ResponseBody
	@RequestMapping("/quality/arrRegList")
	public List<QuaVO> arrRegList(Model model){
		List<QuaVO> rList = quaService.arrRegList();
		model.addAttribute("regList", rList);
		return rList;
	}
	
	// 도착 등록
	@ResponseBody
	@PostMapping("/quality/arrRegister")
	public String arrRegister(QuaVO am, MatreqVO mat) {
		
		quaService.insertArr(am);
		System.out.println(am);
		quaService.mrUpdate(mat);
		System.out.println(mat);
		return "redirect:/quality/arrRegList";
	}
	
	// 자재 입고 검사 페이지
	@GetMapping("/quality/recInsp")
	public void recInsp() {
		
	}
	
	// 입고 검사 대기 등록 리스트
	@ResponseBody
	@RequestMapping("/quality/proRecList")
	public List<QuaVO> proRecList(Model model){
		List<QuaVO> prList = quaService.proRecList();
		model.addAttribute("proRecList", prList);
		return prList;
	}
	
	// 자재 입고 검사 등록
	@ResponseBody
	@PostMapping("/quality/prRegister")
	public String prRegister(@RequestParam Map<String, Object> paramMap) throws JsonMappingException, JsonProcessingException {
		String jsonData = paramMap.get("list").toString();
		System.out.println(jsonData);
		ObjectMapper objectMapper = new ObjectMapper();
		int[] dataArray = objectMapper.readValue(jsonData, int[].class);
		System.out.println(dataArray.length);
		for(int i : dataArray) {
			System.out.println(i);
			/*
			 * quaService.insertPr(i); quaService.mrUpdate(i);
			 */
		}
		return "/quality/proRecList";
	}
	
	
	// 입고 검사 대기 리스트
	@ResponseBody
	@RequestMapping("/quality/prInspList")
	public List<QuaVO> prInspList(Model model){
		List<QuaVO> priList = quaService.prInspList();
		model.addAttribute("priList", priList);
		return priList;
	}


}
