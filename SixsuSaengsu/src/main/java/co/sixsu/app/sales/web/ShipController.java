package co.sixsu.app.sales.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.sales.domain.LotVO;
import co.sixsu.app.sales.domain.OrdVO;
import co.sixsu.app.sales.domain.ShipVO;
import co.sixsu.app.sales.service.ShipService;

@Controller	
@RequestMapping("/sales/")
public class ShipController {
	@Autowired
	private ShipService service;
	
	@GetMapping("ship")
	public void ship() {
		
	}
	
	//페이지 주문중인 목록 (품질요청 전 그리드 테이블)
	@ResponseBody
	@RequestMapping("orderedList")
	public List<OrdVO> orderingList(){
		List<OrdVO> list = service.orderingList();
		
		return list;
	}
	//모달창 품목별 lot 재고현황
	@RequestMapping("lotProducts")
	@ResponseBody
	public List<LotVO> lotProducts(@RequestParam String result){
		System.out.println(result);
		
		List<LotVO> list =service.lotProducts(result);
		return list;
	}
	//모달창에 자동으로 총수량이 뜨는 기능
	@RequestMapping("totalQt")
	@ResponseBody
	public int totalQt(@RequestParam String result) {
		System.out.println(result);
		service.totalQt(result);
		
		return service.totalQt(result) ;
	}
	
	@ResponseBody//////출고등록
	@PostMapping("shipPro")
	public List<ShipVO> shipPro(@RequestBody OrdVO ord, Principal principal){
		ord.setEmpId(principal.getName());
		return service.shipPro(ord);
	}
	
	@ResponseBody
	@RequestMapping("readyShipList")
	public List<ShipVO> readyShipList(@RequestParam(required = false) String result){
		List<ShipVO> list = service.readyShipList(result);
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping("completShip")
	public List<ShipVO> compeletShip(ShipVO vo){
		
		service.completeShip(vo);
		return null;
	}
	@GetMapping("shipInquiry")
	public void shipInquiry() {
		
	}
	@RequestMapping("searchShip")
	@ResponseBody
	public List<ShipVO> searchShip(ShipVO vo) {
		List<ShipVO> list = service.searchShip(vo);
		return list;
	}
}
