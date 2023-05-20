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
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.sales.domain.OrdVO;
import co.sixsu.app.sales.service.SalesService;

@Controller
public class SalesController {
	
	@Autowired
	private SalesService service;
	
// 주문서 관리 페이지 열어주기	
 @GetMapping("/sales/invoice")
 public void invoice() {
 } 
 
 
 
 
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

//자동으로 주문번호 등록
@RequestMapping("/sales/makeCode")
@ResponseBody
public String makeCode() {
	
	String makeCode = service.getMakeCode();
	System.out.println(makeCode);
	return makeCode;
}




//자동으로 상세주문 등록하는방법
@RequestMapping("/sales/detailOrd")
@ResponseBody
public List<OrdVO> ordList(){
	List<OrdVO> list = service.getOrdList();
	return list;
}
//상품명을 주문등록페이지로 이동하기위해 json타입으로 데이터를 불러오기
@RequestMapping("/sales/products")
@ResponseBody
public List<ProductVO> prodList(){
	List<ProductVO> list = service.getProdList();
	return list;
}


}
