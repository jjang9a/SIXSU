package co.sixsu.app.sales.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.sales.domain.LotVO;
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
	//모달창 품목별 lot 재고현황
	@RequestMapping("/sales/lotProducts")
	@ResponseBody
	public List<LotVO> lotProducts(@RequestParam String result){
		System.out.println(result);
		
		List<LotVO> list =service.lotProducts(result);
		return list;
	}
	//모달창에 자동으로 총수량이 뜨는 기능
	@RequestMapping("/sales/totalQt")
	@ResponseBody
	public int totalQt(@RequestParam String result) {
		System.out.println("---------------------");
		System.out.println("asdlfkjas;ldfkj;alskdjf;aslkdjf");
		System.out.println(result);
		service.totalQt(result);
		
		return service.totalQt(result) ;
	}
	
}
