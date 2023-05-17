package co.sixsu.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.domain.common.EmpVO;
import co.sixsu.app.domain.equipment.EquConVO;
import co.sixsu.app.mapper.EquMapper;
import co.sixsu.app.service.EquService;


@Controller
public class EquController {
	
	@Autowired EquService equService;
	
	
//	@GetMapping("/equ1")
//	public String equ1() {
//		System.out.println("페이지.");
//		return "/equipment/equ1";
//	}
	
	@ResponseBody
	@RequestMapping("/equ/equConList")
	public List<EquConVO> equConList(Model modal) {
		 List<EquConVO> list = equService.equConList();
		 modal.addAttribute("list", list);
		 return list;
	}
	 
	@GetMapping("/equConList") // 설비관리 목록
	public List<EquConVO> toastDataList1() {
		List<EquConVO> list = equService.equConList();
		return list;
	}
	
	
}
