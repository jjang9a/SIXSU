package co.sixsu.app.sales.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import co.sixsu.app.sales.service.ReceiveService;

@Controller
public class ReceiveController {

	 	@Autowired
	 	private ReceiveService service;
	 	
//입고 관리 페이지 열어주기
@GetMapping("/sales/receive")
public void receive() {	
}
	
	
	
}
