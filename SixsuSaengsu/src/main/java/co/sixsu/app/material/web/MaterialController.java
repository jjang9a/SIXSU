package co.sixsu.app.material.web;

import java.io.IOException;
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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import co.sixsu.app.material.domain.MatVO;
import co.sixsu.app.material.domain.MatrecVO;
import co.sixsu.app.material.domain.MatrecWaitVO;
import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.material.service.MaterialsService;



@Controller
public class MaterialController {
	
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
	
	//자재Lot조회 페이지 열어주기
	@GetMapping("/materials/mlot")
	public void mlot() {
	}
	
	//발주내역 DB에서 불러오기
	@ResponseBody
	@RequestMapping("/materials/matreqlist")
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
	
	//입고등록
	@PostMapping("/materials/insertmatrec")
    @ResponseBody
    public void insertMatRec(@RequestBody String reqId) {
        System.out.println(reqId);
        ObjectMapper objectMapper = new ObjectMapper(); //json데이터를 java객체로 변환 or java객체를 json데이터로 변환
        try {
            JsonNode rootNode = objectMapper.readTree(reqId); //reqId 문자열을 JSON트리로 변환
            if (rootNode.isArray()) { //JSON트리의 루트 노드가 배열인지 확인
                ArrayNode arrayNode = (ArrayNode) rootNode; //배열이면 arrayNode로 형변환
                for (JsonNode node : arrayNode) {
                    String value = node.asText(); //각 요소를 문자열로 변환
                    System.out.println(value);
                    service.insertMatRec(value);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	//자재 리스트
	@ResponseBody
	@RequestMapping("/materials/matlist")
	public List<MatVO> selectMatList(){
		List<MatVO> list = service.selectMatList();
		System.out.println(list);
		return list;
	}
	

}



