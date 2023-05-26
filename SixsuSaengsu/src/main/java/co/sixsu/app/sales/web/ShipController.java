package co.sixsu.app.sales.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.sales.domain.OrdVO;
import co.sixsu.app.sales.service.ShipService;

@Controller		
public class ShipController {
	@Autowired
	private ShipService service;
	
	@GetMapping("/sales/ship")
	public void ship() {
		
	}
	
	//페이지 주문중인 목록 (품질요청 전 그리드 테이블)
	@ResponseBody
	@RequestMapping("/sales/orderedList")
	public List<OrdVO> orderingList(){
		List<OrdVO> list = service.orderingList();
		
		return list;
	}
	
}
