package co.sixsu.app.material.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.sixsu.app.material.domain.MatrecListVO;
import co.sixsu.app.material.domain.MatrecVO;
import co.sixsu.app.material.domain.MatrecWaitVO;
import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.material.service.MaterialsService;



@Controller
public class MatreqController {
	
	@Autowired MaterialsService service;
//	
//	@GetMapping("/test")
//	public String test() {
//		return "/test";
//	}
	
	
	//발주관리 페이지 열어주기
	@GetMapping("/materials/matreq")
	public void matreqList() {
	}
	
	//자재입고관리 페이지 열어주기
	@GetMapping("/materials/matrec")
	public void matrecList() {
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
	public List<MatreqVO> selectmatreqList(@RequestParam int num){
		System.out.println(num);
		List<MatreqVO> list = service.selectMatReq(num);
		return list;
	}
	
	/*
	@ResponseBody
	@RequestMapping("/materials/delmatreq")
	public String delMatReq(MatreqVO vo, Model modal) {
		
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
	*/
	
	//발주제거 컨트롤
	@ResponseBody
	@RequestMapping("/materials/delmatreq")
	public String delMatReq(@RequestParam Map<String, Object> paramMap) throws Exception {
		String jsonData = paramMap.get("list").toString();
		System.out.println(jsonData);
		ObjectMapper objectMapper = new ObjectMapper();
	    String[] dataArray = objectMapper.readValue(jsonData, String[].class);
	    System.out.println(dataArray.length);
	    for(String i : dataArray) {
	    	System.out.println(i);
	    	service.deleteMatReq(i);
	    }
	    
	    
		return "/materials/matreq";
	}
	
	//발주등록 컨트롤
	@ResponseBody
	@PostMapping("/materials/insertmatreq")
	public MatreqVO insertMatReq(@RequestBody MatreqVO vo) {		
		System.out.println(vo);
		service.insertMatReq(vo);
		return vo;
		
		
	}
	
	
	//입고대기 리스트 모달
	@ResponseBody
	@RequestMapping("/materials/matrecwait")
	public List<MatrecWaitVO> selectMatRecWaitList(){
		List<MatrecWaitVO> list = service.getMatRecWaitList();
		return list;
	}
	
	
	//입고 리스트
	@ResponseBody
	@RequestMapping("/materials/matreclist")
	public List<MatrecVO> selectMatRecList(){
		List<MatrecVO> list = service.getMatRecList();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/materials/insertmatrec")
	public String insertMatRec(@RequestBody List<MatrecVO> list) throws Exception {
		System.out.println(list);
		
		return "success";
		
	}
}



