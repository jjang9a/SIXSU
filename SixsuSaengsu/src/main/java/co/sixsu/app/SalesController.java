package co.sixsu.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.domain.common.EmpVO;
import co.sixsu.app.service.SalesService;

@Controller
public class SalesController {
	
	@Autowired
	private SalesService service;
	
// 주문서 관리 페이지 열어주기	
 @GetMapping("/sales/invoice")
 public void invoice() {
 } 
 
// 주문서 관리 페이지 등록된 주문서 리스트로 뽑기
 
 
// 주문서 관리 사원정보 조회 하기 
@ResponseBody
@RequestMapping("/sales/empList")
public List<EmpVO>  empList() {
	 List<EmpVO> list = service.getEmpList();
	 //modal.addAttribute("list", list);
	 return list;
 }
}
