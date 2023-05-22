package co.sixsu.app.sales.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.basic.domain.BusVO;
import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.domain.ProductVO;
import co.sixsu.app.sales.domain.InvVO;
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

//주문서만 등록
@ResponseBody
@RequestMapping(value = "/sales/orderAdd", method =RequestMethod.POST)
public InvVO orderAdd(InvVO inv){
	
	InvVO result =service.orderAdd(inv);	

	return result;
}

@ResponseBody
@PostMapping("/sales/ordDetAdd") //상세 주문서 등록
public boolean ordDetAdd(@RequestBody List<OrdVO> list) {
	return service.ordDetAdd(list);
}


//

//페이지 하단부분에있는 진행중인 주문서 조회
@RequestMapping("/sales/orderingList")
@ResponseBody
public List<InvVO> orderingList(){
	List<InvVO> list = service.getOrderingList();
	return list;
}

//진행중인 주문서 행을 클릭을 하게되면 거기에 맞는 주문서가 화면에 나오도록 
@RequestMapping("/sales/firstOrderingList")
@ResponseBody
public InvVO firstOrderingList(@RequestParam String result){
	System.out.println(result);
	InvVO list = service.firstOrderingList(result);
	return list;
	
}
}
