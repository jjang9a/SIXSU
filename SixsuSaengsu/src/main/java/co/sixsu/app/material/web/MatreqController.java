package co.sixsu.app.material.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.material.mapper.MaterialsMapper;
import co.sixsu.app.material.service.MaterialsService;

@Controller
public class MatreqController {
	
	@Autowired MaterialsService service;
//	
//	@GetMapping("/test")
//	public String test() {
//		return "/test";
//	}
	
	
	//발주내역 페이지 열어주기
	@GetMapping("/materials/matreq")
	public void matreqList() {
	}
	
	
	
	//발주내역 DB에서 불러오기
	@ResponseBody
	@RequestMapping("/materials/mms")
	public List<MatreqVO> matreqList(Model modal){
		List<MatreqVO> list = service.getMatReqList();
		modal.addAttribute("list", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/materials/smatreq")
	public List<MatreqVO> selectmatList(@RequestParam int num){
		System.out.println(num);
		List<MatreqVO> list = service.selectMatReq(num);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/materials/delmatreq")
	public String delMatReq(MatreqVO vo, Model modal) {
		System.out.println(vo);
		//int result = service.deleteMatReq(vo);
		  
		//vo.setMatReqId(vo); 
		modal.addAttribute("vo",vo);
		//int result = service.deleteMatReq(vo.getMatReqId());
		  
		 //System.out.println(num); 
		 System.out.println(vo);
		 //System.out.println(vo.getMatReqId());
		 
		 int result = service.deleteMatReq(vo.getMatReqId());
		 
		 String re = null; 
		 if(result== 1) { 
			 re = "성공";
		 }
		 else { 
			 re = "실패"; 
		 }
		return "/materials/matreq";
	}
	
	@ResponseBody
	@RequestMapping("/materials/test1")
	public String delMatReq(@ModelAttribute MatreqVO vo) {
		System.out.println(vo);
		return null;
	}
	
	
	
	
}
