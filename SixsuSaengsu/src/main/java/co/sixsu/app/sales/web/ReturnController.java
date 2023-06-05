package co.sixsu.app.sales.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.sales.domain.RetVO;
import co.sixsu.app.sales.domain.ShipCompVO;
import co.sixsu.app.sales.domain.ShipVO;
import co.sixsu.app.sales.service.ReturnService;

@Controller
@RequestMapping("/sales/")
public class ReturnController {
	@Autowired
	private ReturnService service;

	
	@GetMapping("return")
	public void returnPro() {
		
	}
	@ResponseBody
	@RequestMapping("orderComplete")
	public List<ShipCompVO> orderComplete(@RequestParam(required = false) String result){
		List<ShipCompVO> list = service.orderComplete(result);
		
		return list;
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("shipList") public List<ShipVO> lotProducts(@RequestParam String
	 * result){ List<ShipVO> list =service.shipList(result); return list; }
	 */
	
	
	
	
	//
	@GetMapping("returnInquiry")
	public void returnInquiry() {
		
	}
	
	@RequestMapping("searchReturn")
	@ResponseBody
	public List<RetVO> searchReturn(RetVO vo) {
		List<RetVO> list = service.searchReturn(vo);
		return list;
	}
	
}
