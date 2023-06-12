package co.sixsu.app.sales.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import co.sixsu.app.sales.domain.GridDataVO;
import co.sixsu.app.sales.domain.InvVO;
import co.sixsu.app.sales.domain.OrdVO;
import co.sixsu.app.sales.service.SalesService;

//이대규
//주문서 관리
@RequestMapping("/sales/")
@Controller
public class SalesController {

	@Autowired
	private SalesService service;


// 주문서 관리 페이지 열어주기	
	@GetMapping("invoice")
	public void invoice(Model model) {
	
	}
// 주문서 조회 페이지 열어주기	
	@GetMapping("invoiceInfo")
	public void invoiceInfo(Model model) {
	
	}
// 재고 현황 페이지 열어주기
	@GetMapping("inventoryInfo")
	public void inventoryInfo(Model model) {
	
	}
	@ResponseBody
	@RequestMapping("inventorySearch.Ajax")
	public List<OrdVO> inventorySearch() {
		List<OrdVO> list = service.inventorySearch();
		return list;
	}
		
	
	
	
	@RequestMapping("searchOrder.Ajax")
	@ResponseBody 
	public List<InvVO> searchOrder(InvVO vo) { 
		List<InvVO> list = service.searchOrder(vo); 
		return list; 
		}


//모달창 회원이름 조회
	@RequestMapping("emp1List.Ajax")
	@ResponseBody
	public List<EmpVO> emp1List(@RequestParam(required = false) String result) {
		System.out.println(result);
		List<EmpVO> list = service.getEmp1List(result);
		return list;

	}

//거래처 관리 사원정보 조회 하기
	@ResponseBody
	@RequestMapping("busList.Ajax")
	public List<BusVO> busList() {
		List<BusVO> list = service.getBusList();
		return list;
	}
	
//모달창 거래처이름 조회
	@RequestMapping("bus1List.Ajax")
	@ResponseBody
	public List<BusVO> bus1List(@RequestParam(required = false) String result) {
		System.out.println(result);
		List<BusVO> list = service.getBus1List(result);
		return list;

	}



//자동으로 상세주문 등록하는방법
	@RequestMapping("detailOrd.Ajax")
	@ResponseBody
	public List<OrdVO> ordList() {
		List<OrdVO> list = service.getOrdList();
		return list;
	}

//상품명을 주문등록페이지로 이동하기위해 json타입으로 데이터를 불러오기
	@RequestMapping("products.Ajax")
	@ResponseBody
	public List<ProductVO> prodList() {
		List<ProductVO> list = service.getProdList();
		return list;
	}

//주문서만 등록
	@ResponseBody
	@RequestMapping(value = "orderAdd.Ajax", method = RequestMethod.POST)
	public InvVO orderAdd(@RequestBody InvVO inv) {

		service.orderAdd(inv);

		return inv;
	}

	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("ordDetAdd") // 상세 주문서 등록 public boolean ordDetAdd(@RequestBody
	 * List<OrdVO> list) { System.out.println("------------------------------");
	 * System.out.println(list); return service.ordDetAdd(list);
	 * 
	 * }
	 */

//

//페이지 하단부분에있는 진행중인 주문서 조회
	@RequestMapping("orderingList")
	@ResponseBody
	public List<InvVO> orderingList() {
		List<InvVO> list = service.getOrderingList();
		return list;
	}

//진행중인 주문서 행을 클릭을 하게되면 거기에 맞는 주문서가 화면에 나오도록 
	@RequestMapping("firstOrderingList")
	@ResponseBody
	public InvVO firstOrderingList(@RequestParam String result) {

		System.out.println(result);
		InvVO list = service.firstOrderingList(result);
		return list;

	}

//진행중인 주문서 행을 클릭을 하게되면 거기에 맞는 주문서가 화면에 나오도록 
	@RequestMapping("secondOrderingList")
	@ResponseBody
	public List<OrdVO> secondOrderingList(@RequestParam String result) {
		System.out.println(result);
		List<OrdVO> list = service.secondOrderingList(result);
		return list;

	}

//주문서 수정
	@ResponseBody
	@PostMapping("orderMod") // 사원정보 수정 ajax
	public String orderMod(InvVO inv) {

		System.out.println(inv);
		service.orderMod(inv);
		return "result";
	}

//상세주문서 수정
	@ResponseBody
	@PostMapping("ordDetMod") // 상세 주문서 등록
	public boolean ordDetMod(@RequestBody GridDataVO<OrdVO> list) {

		System.out.println(list);
		service.ordDetMod(list);
		return true;
	}

	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("productDel") public String productDel(@RequestParam
	 * Map<String, Object> paramMap) throws Exception { String jsonData =
	 * paramMap.get("list").toString(); System.out.println(jsonData); ObjectMapper
	 * objectMapper = new ObjectMapper(); String[] dataArray =
	 * objectMapper.readValue(jsonData, String[].class);
	 * System.out.println(dataArray.length); for (String i : dataArray) {
	 * System.out.println(i); service.productDel(i); }
	 * 
	 * return "productDel"; }
	 */
	@ResponseBody
	@PostMapping("orderModDel") // 사원정보 수정 ajax
	public String orderModDel(InvVO inv) {

		System.out.println(inv);

		service.orderModDel(inv);
		return "result";
	}

	
	//상세주문서 수정
	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("ordDetModDel") //상세 주문서 등록 public boolean
	 * ordDetModDel(@RequestBody List<OrdVO> list) {
	 * System.out.println("---------------------------------------------");
	 * System.out.println(list); return service.ordDetModDel(list); }
	 */
	 

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//주문서 관리 페이지 열어주기	

}
