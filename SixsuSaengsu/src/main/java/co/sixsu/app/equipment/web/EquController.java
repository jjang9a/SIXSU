package co.sixsu.app.equipment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.equipment.domain.EquConVO;
import co.sixsu.app.equipment.domain.EquInspVO;
import co.sixsu.app.equipment.domain.EquOperVO;
import co.sixsu.app.equipment.domain.EquSearchDTO;
import co.sixsu.app.equipment.service.EquService;


@Controller
public class EquController {
	@Autowired EquService equService;
	
	
	// 설비 관리 페이지 - 관리페이지 기능은 /equipment/equCon - 수행.
	@GetMapping("/equipment/equConpage") 
	public void equCon() {
	}
	
	@GetMapping("/equipment/equSearch") // 설비 조회 페이지
	public void equSearch() {
	}
	
	@GetMapping("equipment/equCheckSP") // 점검 조회 페이지
	public void equCheckSP() {
	}
	
	@GetMapping("equipment/equCheckCP") // 점검관리 페이지
	public void equCheckCP() {
	}
	
	@GetMapping("equipment/equOperSP") // 비가동 조회 페이지
	public void equOperSP() {
	}
	
	@GetMapping("equipment/equOperCP") // 비가동 관리 페이지
	public void equOperCP() {
	}
   
	@ResponseBody
	@GetMapping("/equipment/equCon") //설비 리스트 ajax
	public List<EquConVO> equList(){
		List<EquConVO> list = equService.equConList();
		return list;
	}
	
	@ResponseBody 
	@PostMapping("/equipment/equAdd") // 설비관리(등록) 
	public EquConVO equAdd(EquConVO data) { 
		equService.equAdd(data);
		return data;
	}
	
	@ResponseBody
	@GetMapping("/equipment/activePdList") // 등록 공정코드(조회) ajax
	public List<ProductVO> activePdList() {
		return equService.activePdList();
	}
	
	@ResponseBody 
	@PostMapping("/equipment/equUpdate") // 설비관리(수정) 
	public EquConVO equUpdate(EquConVO data) {
		System.out.println("컨트롤러 : "+ data);
		equService.equUpdate(data);
		return data;
	}

	// [설비 관리 페이지] - 삭제
	@ResponseBody 
	@PostMapping("/equipment/equDel")  // 설비관리(삭제)
	public boolean equdel(@RequestBody EquConVO equCode) {
	    System.err.println(equCode);
		  if(equService.equDel(equCode)) {
			  return true ;

		  }else {
			  return false;
		  }
	} 
	 
	@ResponseBody // 설비조회 상세정보(모달에 데이터를 보내줌)
	@RequestMapping("/equipment/equInfo") // 설비 조회 상세정보 리스트
	public List<EquConVO> equInfo(@ModelAttribute EquConVO info) { //담고 담아서
		String equCode = info.getEquCode(); // info 안에 필드값 EquCode를
		System.out.println(equCode); // 콘솔창에 뿌려줌
		return null; // 모달 창으로 리턴해야함.
	
	}
	
	@ResponseBody // 설비조회 검색 기능 / 아작스로 데이터를 요청 리스트로 받음
	@RequestMapping("/equipment/equFilterAjax")
	public List equFilterList(EquSearchDTO dto) {
		System.out.println("데이터");
		System.out.println(dto);
		List<EquConVO> list = equService.equFilterList(dto);
		return list;
	}
	
	@ResponseBody // 점검조회 검색 기능 / 아작스로 데이터를 요청 리스트로 받음
	@RequestMapping("/equipment/equCheckSearch")
	public List equCheckSearch(EquSearchDTO dto) {
		System.out.println("데이터");
		System.out.println(dto);
		List<EquInspVO> list = equService.equCheckSearch(dto);
		return list;
	}
	
	@ResponseBody
	@GetMapping("/equipment/equCheckList") //// 점검 조회 리스트 ajax
	public List<EquInspVO> equCheckList(){
		List<EquInspVO> list = equService.equCheckList();
		return list;
	}
	
	@ResponseBody
	@GetMapping("/equipment/equOperList") //// 비가동 조회 리스트 ajax
	public List<EquOperVO> equOperList(){
		List<EquOperVO> list = equService.equOperList();
		return list;
	}
	
	@ResponseBody // 비가동 검색 기능 / 아작스로 데이터를 요청 리스트로 받음
	@RequestMapping("/equipment/equOperSearch")
	public List equOperSearch(EquSearchDTO dto) {
		System.out.println("데이터");
		System.out.println(dto);
		List<EquOperVO> list = equService.equOperSearch(dto);
		return list;
	}
	
	

	
	
	
	// 점검 조회
	
	// 비가동 관리 페이지
	
	// 비가동 조회
}
