package co.sixsu.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.domain.common.EmpVO;
import co.sixsu.app.domain.equipment.EquConVO;
import co.sixsu.app.mapper.EquMapper;
import co.sixsu.app.service.EquService;


@Controller
public class EquController {
	@Autowired EquService equService;
	
	

	@GetMapping("/equipment/equ1") // 설비 관리 페이지
	public void equ1() {
	}
	
	@GetMapping("/equipment/equ2") // 설비 조회 페이지
	public void equ2() {
	}
	 
	@GetMapping("/equipment/equConList") //리스트
	public String equList(Model model){
		model.addAttribute("equConList", equService.equConList());
		return "/equipment/equ1";
	}

	
	@ResponseBody
	@RequestMapping("/equipment/equConList1") // 설비 관리 리스트
	public List<EquConVO> equConList() {
		 List<EquConVO> list = equService.equConList();
		 System.out.println(list);
		 //modal.addAttribute("list", list);Model modal
		 return list;
	}

	
	@ResponseBody // 모달에 데이터를 보내줌
	@RequestMapping("/equipment/equInfo") // 설비 조회 상세정보 리스트
	public List<EquConVO> equInfo(@ModelAttribute EquConVO info) { //담고 담아서
		String equCode = info.getEquCode(); // info 안에 필드값 EquCode를
		System.out.println(equCode); // 콘솔창에 뿌려줌
		List<EquConVO> list = equService.equInfo(equCode); // 리스트 형식 list에 담아서 
		return null; // 모달 창으로 리턴해야함.
	
	}
//	//모달창 설비코드 클릭시 상세정보
//	@RequestMapping("/equipment/empInfoList")
//	@ResponseBody
//	public List<EmpVO> empInfoList(@RequestParam String result){
//		System.out.println(result);
//		List<EmpVO> list = equService.empInfoList(result);
//		
//	}
	
	

//	@GetMapping("equ/equcon") // 설비관리 페이지 불러오기
//	public void equcon() {
//	}
	
//	@GetMapping("equ/equcheck") // 점검관리 페이지
//	public void equcheck() {
//	}
	
	// 점검 조회
	
	// 점검 조회
	
	// 비가동 관리 페이지
	
	// 비가동 조회
}
