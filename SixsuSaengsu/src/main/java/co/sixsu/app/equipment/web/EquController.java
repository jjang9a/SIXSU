package co.sixsu.app.equipment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.basic.service.BasicService;
import co.sixsu.app.equipment.domain.EquConVO;
import co.sixsu.app.equipment.domain.EquInspVO;
import co.sixsu.app.equipment.domain.EquOperVO;
import co.sixsu.app.equipment.domain.EquSearchDTO;
import co.sixsu.app.equipment.service.EquService;


/*
 * 고대준
 * 설비관리
 * 0530
 */
@Controller
@RequestMapping("/equipment/")
public class EquController {
	@Autowired EquService equService;
	@Autowired BasicService basicService;
	
	
	// 설비 관리 페이지 - 관리페이지 기능은 /equCon - 수행.
	@GetMapping("equConpage") 
	public void equCon() {
	}
	
	@GetMapping("equSearch") // 설비 조회 페이지
	public void equSearch() {
	}
	
	@GetMapping("equCheckSP") // 점검 조회 페이지
	public void equCheckSP() {
	}
	
	@GetMapping("equCheckCP") // 점검관리 페이지
	public void equCheckCP(Model model) {
		String key = "EQU_SUIT";
		model.addAttribute("types", basicService.getComList(key));
	}
	
	@GetMapping("equOperSP") // 비가동 조회 페이지
	public void equOperSP() {
		
	}
	
	@GetMapping("equOperCP") // 비가동 관리 페이지
	public void equOperCP(Model model) {
		String key = "OPER_TYPE";
		model.addAttribute("types", basicService.getComList(key));
	}
   
	@ResponseBody
	@GetMapping("equCon") //설비 리스트 ajax
	public List<EquConVO> equList(){
		List<EquConVO> list = equService.equConList();
		return list;
	}
	
	@ResponseBody 
	@PostMapping("equAdd") // 설비관리(등록) 
	public EquConVO equAdd(EquConVO data) { 
		equService.equAdd(data);
		return data;
	}
	
	@ResponseBody
	@GetMapping("activePdList") // 설비관리 공정코드(조회)
	public List<ProductVO> activePdList() {
		return equService.activePdList();
	}
	
	@ResponseBody 
	@PostMapping("equUpdate") // 설비관리(수정) 
	public EquConVO equUpdate(EquConVO data) {
		System.out.println("컨트롤러 : "+ data);
		equService.equUpdate(data);
		return data;
	}

	// [설비 관리 페이지] - 삭제
	@ResponseBody 
	@PostMapping("equDel")  // 설비관리(삭제)
	public boolean equdel(@RequestBody EquConVO equCode) {
	    System.err.println(equCode);
		 return equService.equDel(equCode);
	} 
	 
	@ResponseBody // 설비조회(검색) 
	@RequestMapping("equFilterAjax")
	public List<EquConVO> equFilterList(EquSearchDTO dto) {
		System.out.println("데이터");
		System.out.println(dto);
		List<EquConVO> list = equService.equFilterList(dto);
		return list;
	}
	
	@ResponseBody // 점검조회(검색) 
	@RequestMapping("equCheckSearch")
	public List<EquInspVO> equCheckSearch(EquSearchDTO dto) {
		System.out.println("데이터");
		System.out.println(dto);
		List<EquInspVO> list = equService.equCheckSearch(dto);
		return list;
	}
	
	@ResponseBody
	@GetMapping("equCheckList") //// 점검 조회 리스트 
	public List<EquInspVO> equCheckList(){
		List<EquInspVO> list = equService.equCheckList();
		return list;
	}
	
	@ResponseBody 
	@PostMapping("checkAdd") // 점검관리(등록) 
	public EquInspVO checkAdd(EquInspVO data) { 
		equService.checkAdd(data);
		return data;
	} 
	
	@ResponseBody 
	@PostMapping("cUpdate") // 점검관리(수정) 
	public EquInspVO cUpdate(EquInspVO data) {
	//	System.out.println("컨트롤러 : "+ data);
		equService.cUpdate(data);
		return data;
	}
	
	@ResponseBody 
	@PostMapping("cDel")  // 점검관리(삭제)
	public boolean cDel(@RequestBody EquInspVO checkCode) {
	    System.out.println(checkCode);
		 return equService.cDel(checkCode);
	} 
	
	@ResponseBody
	@GetMapping("equOperList") //// 비가동 조회 리스트 ajax
	public List<EquOperVO> equOperList(){
		List<EquOperVO> list = equService.equOperList();
		return list;
	}
	
	@ResponseBody // 비가동 검색 기능 / 아작스로 데이터를 요청 리스트로 받음
	@RequestMapping("equOperSearch")
	public List<EquOperVO> equOperSearch(EquSearchDTO dto) {
		System.out.println("데이터");
		System.out.println(dto);
		List<EquOperVO> list = equService.equOperSearch(dto);
		return list;
	}
	
	@ResponseBody 
	@PostMapping("oUpdate") // 비가동 관리(수정) 
	public EquOperVO oUpdate(EquOperVO data) {
		equService.oUpdate(data);
		return data;
	}
	
	@ResponseBody 
	@PostMapping("oDel")  // 비가동 관리(삭제)
	public boolean oDel(@RequestBody EquOperVO operCode) {
	    System.out.println(operCode);
		 return equService.oDel(operCode);
	} 
	
	@ResponseBody 
	@PostMapping("startIn") // 비가동 관리 시작버튼(등록) 
	public EquOperVO startIn(EquOperVO data) { 
		equService.startIn(data);
		return data;
	} 
	
	@ResponseBody 
	@PostMapping("startUp") // 비가동 관리 시작버튼(수정/설비상태) 
	public EquOperVO startUp(EquOperVO data) { 
		equService.startUp(data);
		return data;
	} 

	
	
	
	
}
