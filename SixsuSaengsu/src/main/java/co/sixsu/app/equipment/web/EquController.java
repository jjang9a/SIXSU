package co.sixsu.app.equipment.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.equipment.domain.EquConVO;
import co.sixsu.app.equipment.service.EquService;


@Controller
public class EquController {
	@Autowired EquService equService;
	
	
	// 설비 관리 페이지
	@GetMapping("/equipment/equCon") 
	public void equCon() {
	}
	
	// 설비 조회 페이지
	@GetMapping("/equipment/equSearch") 
	public void equSearch() {
	}
    //설비 관리 페이지 리스트
	@GetMapping("/equipment/equConList") 
	public String equList(Model model){
		model.addAttribute("equConList", equService.equConList());
		return "/equipment/equCon";
	}
	// 설비 관리 리스트 ajax
	@ResponseBody 
	@RequestMapping("/equipment/equConList1") 
	public List<EquConVO> equConList() {
		 List<EquConVO> list = equService.equConList();
		 System.out.println(list);
		 return list;
	}
	
	@ResponseBody // 설비 등록 ajax
	@PostMapping("/equipment/equAdd")
	public EquConVO equAdd(EquConVO data) { 
		equService.equAdd(data);
		return data;
	}
	/*
	 * @ResponseBody // 설비 수정 ajax
	 * 
	 * @PostMapping("/equipment/equUpdate") boolean public equUpdate(@RequestBody) {
	 * int result = equService.equUpdate(data); System.out.println(result); return
	 * data; }
	 */

	@ResponseBody // 설비조회 상세정보(모달에 데이터를 보내줌)
	@RequestMapping("/equipment/equInfo") // 설비 조회 상세정보 리스트
	public List<EquConVO> equInfo(@ModelAttribute EquConVO info) { //담고 담아서
		String equCode = info.getEquCode(); // info 안에 필드값 EquCode를
		System.out.println(equCode); // 콘솔창에 뿌려줌
		List<EquConVO> list = equService.equInfo(equCode); // 리스트 형식 list에 담아서 
		System.out.println(list);
		return null; // 모달 창으로 리턴해야함.
	
	}
	
	@ResponseBody // 검색 기능 / 아작스로 데이터를 요청 리스트로 받음
	@RequestMapping("/equipment/equFilterAjax")
	public List equFilterList(@ModelAttribute EquConVO data) {
		System.out.println("데이터");
		System.out.println(data);
		List<EquConVO> list = equService.equFilterList(data);
		return list;
	}
	
	
	
	
	
//	@GetMapping("equ/equcheck") // 점검관리 페이지
//	public void equcheck() {
//	}
	
	// 점검 조회
	
	// 점검 조회
	
	// 비가동 관리 페이지
	
	// 비가동 조회
}
