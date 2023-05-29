package co.sixsu.app.basic.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.basic.domain.ReceiveVO;
import co.sixsu.app.basic.service.ProductService;

@Controller
public class ProductController {

	@Autowired ProductService service;
	
	// 반제품 입고관리
	
	@GetMapping("prod/spRec")
	public void spRec() { // 반제품 입고 페이지 띄우기
	}
	
	@ResponseBody
	@GetMapping("/prod/readySpList") // 반제품 입고 대기 리스트
	public List<ReceiveVO> readySpList(){
		List<ReceiveVO> list = service.readySpList();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@GetMapping("/prod/spRecList") // 반제품 입고 내역
	public List<ReceiveVO> spRecList(){
		List<ReceiveVO> list = service.spRecList();
		return list;
	}
	
	@ResponseBody
	@PostMapping("/prod/spRec") // 반제품 입고
	public List<ReceiveVO> spRec(@RequestBody List<ReceiveVO> list){
		return service.spRec(list);
	}
	
	
	// 완제품 입고 관리
	
	@GetMapping("prod/cpRec")
	public void cpRec() { // 완제품 입고 페이지 띄우기
	}
	
	@ResponseBody
	@GetMapping("/prod/readyCpList") // 완제품 입고 대기 리스트
	public List<ReceiveVO> readyCpList(){
		List<ReceiveVO> list = service.readyCpList();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@GetMapping("/prod/cpRecList") // 완제품 입고 내역
	public List<ReceiveVO> cpRecList(){
		List<ReceiveVO> list = service.cpRecList();
		return list;
	}
	
}
