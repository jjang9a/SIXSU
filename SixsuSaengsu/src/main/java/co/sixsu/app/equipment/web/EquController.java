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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.equipment.domain.EquConVO;
import co.sixsu.app.equipment.service.EquService;


@Controller
public class EquController {
	@Autowired EquService equService;
	
	
	// 관리페이지 기능은 /equipment/equCon - 수행.
	@GetMapping("/equipment/equConpage")  // 설비 관리 페이지
	public void equCon() {
	}
	
	@GetMapping("/equipment/equSearch") // 설비 조회 페이지
	public void equSearch() {
	}
    
	@GetMapping("equipment/equCheck") // 점검관리 페이지
	public void equcheck() {
	}
	// [ 설비 ] - 리스트
	@ResponseBody
	@GetMapping("/equipment/equCon") //설비 리스트 ajax
	public List<EquConVO> equList(){
		List<EquConVO> list = equService.equConList();
		return list;
	}
	// [설비 관리 페이지] - 등록
	@ResponseBody // 설비관리(등록) 
	@PostMapping("/equipment/equAdd")
	public EquConVO equAdd(EquConVO data) { 
		System.err.println(data);
		equService.equAdd(data);
		return data;
	}
	// [설비 관리 페이지] - 수정
	@ResponseBody // 설비관리(수정) 
	@PostMapping("/equipment/equUpdate") 
	public EquConVO equUpdate(EquConVO data) {
		equService.equUpdate(data);
		return data;
	}
	
	// [설비 관리 페이지] - 삭제
	@ResponseBody // 설비관리(삭제) 
	@PostMapping("/equipment/equDel") 
	public String equdel(@RequestBody EquConVO equCode) {
	    System.err.println(equCode);
		  if(equService.equDel(equCode)) {
			  return "success" ;

		  }else {
			  return "fail";
		  }
	} 
	
	// [설비 조회 페이지] - 검색기능
	@ResponseBody // 검색 기능 / 아작스로 데이터를 요청 리스트로 받음
	@RequestMapping("/equipment/equFilterAjax")
	public List equFilterList(@ModelAttribute EquConVO data) {
		System.out.println("데이터");
		System.out.println(data);
		List<EquConVO> list = equService.equFilterList(data);
		return list;
	}
	
	// 점검 페이지
//	@ResponseBody
//	@GetMapping("/equipment/equCheckList") //설비 리스트 ajax
//	public List<EquConVO> equCheckList(){
//		List<EquConVO> list = equService.equCheckList();
//		return list;
//	}
	
	// 점검 조회
	
	// 점검 조회
	
	// 비가동 관리 페이지
	
	// 비가동 조회
}
