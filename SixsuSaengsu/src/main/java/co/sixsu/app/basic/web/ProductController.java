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
	
	@GetMapping("prod/spRec")
	public void spRec() { // 반제품 입고 페이지 띄우기
	}
	
	@ResponseBody
	@GetMapping("/prod/readySpList")
	public List<ReceiveVO> readySpList(){
		List<ReceiveVO> list = service.readySpList();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@PostMapping("/prod/spRec")
	public List<ReceiveVO> spRec(@RequestBody List<ReceiveVO> list){
		return service.spRec(list);
	}
	
}
