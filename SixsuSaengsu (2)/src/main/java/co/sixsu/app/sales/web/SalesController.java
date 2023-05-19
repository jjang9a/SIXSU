package co.sixsu.app.sales.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.basic.domain.BusVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.sales.service.SalesService;

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


//모달창 회원이름 조회
@RequestMapping("/sales/emp1List")
@ResponseBody
public List<EmpVO> emp1List(@RequestParam String result){
	System.out.println(result);
	List<EmpVO> list = service.getEmp1List(result);
	return list;
	
}

//거래처 관리 사원정보 조회 하기
@ResponseBody
@RequestMapping("/sales/busList")
public List<BusVO> busList(){
	List<BusVO> list = service.getBusList();
	return list;
}
//모달창 거래처이름 조회

@RequestMapping("/sales/bus1List")
@ResponseBody
public List<BusVO> bus1List(@RequestParam String result){
	System.out.println(result);
	List<BusVO> list = service.getBus1List(result);
	return list;
	
}

}
