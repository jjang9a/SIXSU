package co.sixsu.app.equipment.web;

import java.time.LocalDate;
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
	public void equCon(Model model) {
		String key = "EQU_STAT";
		model.addAttribute("equStat", basicService.commGroupList(key));
	}
	
	@GetMapping("EquInfo") // 설비 조회 페이지
	public void EquInfo(Model model) {
		String key = "EQU_STAT";
		String key2 = "EQU_SUIT";
		String key3 = "CHECK_TYPE";
		String key4 = "OPER_TYPE";
		model.addAttribute("equStat", basicService.commGroupList(key));
		model.addAttribute("equSuit", basicService.commGroupList(key2));
		model.addAttribute("checkType", basicService.commGroupList(key3));
		model.addAttribute("operType", basicService.commGroupList(key4));
	}
	
	@GetMapping("CheckInfo") // 점검 조회 페이지
	public void CheckInfo(Model model) {
		String key = "EQU_SUIT";
		String key2 = "CHECK_TYPE";
		model.addAttribute("equSuit", basicService.commGroupList(key));
		model.addAttribute("checkType", basicService.commGroupList(key2));
	}
	
	@GetMapping("equCheckCP") // 점검관리 페이지
	public void equCheckCP(Model model) {
		String key = "EQU_SUIT";
		String key2 = "CHECK_TYPE";
		model.addAttribute("equSuit", basicService.commGroupList(key));
		model.addAttribute("checkType", basicService.commGroupList(key2));
	}
	
	@GetMapping("OperInfo") // 비가동 조회 페이지
	public void equOperSP(Model model) {
		String key = "OPER_TYPE";
		String key2 = "EQU_STAT";
		model.addAttribute("operType", basicService.commGroupList(key));
		model.addAttribute("equStat", basicService.commGroupList(key2));
	}
	
	@GetMapping("equOperCP") // 비가동 관리 페이지
	public void equOperCP(Model model) {
		String key = "OPER_TYPE";
		String key2 = "EQU_STAT";
		model.addAttribute("operType", basicService.commGroupList(key));
		model.addAttribute("equStat", basicService.commGroupList(key2));
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
		System.out.println(data);
		equService.checkAdd(data);
		return data;
	} 
	
	@ResponseBody 
	@PostMapping("cUpdate") // 점검관리(수정) 
	public EquInspVO cUpdate(EquInspVO data) {
		//System.err.println("컨트롤러 : "+ data);
		equService.cUpdate(data);
		return data;
	}
	
	@ResponseBody 
	@PostMapping("cDel")  // 점검관리(삭제)
	public boolean cDel(@RequestBody EquInspVO checkCode) {
	    System.err.println("컨트롤러 : "+ checkCode);
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
	public List<EquOperVO> equOperSearch(EquOperVO vo) {
		System.out.println("데이터");
		System.out.println(vo);
		List<EquOperVO> list = equService.equOperSearch(vo);
		return list;
	}
	
	@ResponseBody 
	@PostMapping("oUpdate") // 비가동 관리(수정) 
	public EquOperVO oUpdate(EquOperVO data) {
		System.out.println(data);
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
	@PostMapping("startIn") // 비가동 관리 비가동 시작버튼(비가동 등록) 
	public EquOperVO startIn(EquOperVO data) { 
		System.out.println(data);
		equService.startIn(data);
		EquOperVO vo = new EquOperVO();
		vo.setOperCode(data.getOperCode());
		return equService.equOperSearch(vo).get(0);
	} 

	@ResponseBody 
	@PostMapping("fnishIn") // 비가동 관리 비가동 종료버튼(가동 등록) 
	public List<EquOperVO> fnishIn(EquOperVO data) { 
		 //equService.fnishIn(data);
		 //LocalDate now = LocalDate.now(); String date = now.toString();
		 //data.setOperFnish(date); System.out.println(data); 
		 return equService.fnishIn(data);
		 
		/*
		 *; return data;
		 */
	}
	

	
	
	
	
}
