package co.sixsu.app.basic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.basic.service.ProductService;

@Controller
public class ProductController {

	@Autowired ProductService service;
	
	@GetMapping("prod/spRec")
	public void spRec() { // 반제품 입고 페이지 띄우기
	}
	
//	@ResponseBodys
//	@GetMapping("prod/readySpList")
//	public List<>
	
	
}
