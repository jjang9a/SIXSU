package co.sixsu.app.sales.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.sales.domain.RecVO;
import co.sixsu.app.sales.service.ReceiveService;

@Controller
public class ReceiveController {

	 	@Autowired
	 	private ReceiveService service;
	 	
//입고 관리 페이지 열어주기
@GetMapping("/sales/receive")
public void receive() {	
}

//생산완료 입고전 품목 조회 하기
@ResponseBody
@RequestMapping("/sales/completeList")
public List<RecVO> completeList(){
	List<RecVO> list= service.completeList();
	
	return list;
}
	
	
	
}
