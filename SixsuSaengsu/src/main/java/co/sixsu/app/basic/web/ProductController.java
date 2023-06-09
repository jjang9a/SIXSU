package co.sixsu.app.basic.web;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.basic.domain.ReceiveVO;
import co.sixsu.app.basic.domain.SalesVO;
import co.sixsu.app.basic.service.BasicService;
import co.sixsu.app.basic.service.ProductService;
import co.sixsu.app.quality.domain.QilVO;
import co.sixsu.app.work.domain.PfmcVO;

@Controller
public class ProductController {

	@Autowired ProductService service;
	@Autowired BasicService basicService;
	
	// 반제품 입고관리
	
	@GetMapping("prod/spRec")
	public void spRec() { // 반제품 입고 페이지 띄우기
	}
	
	@ResponseBody
	@GetMapping("/prod/readySpList.Ajax") // 반제품 입고 대기 리스트
	public List<ReceiveVO> readySpList(){
		List<ReceiveVO> list = service.readySpList();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@GetMapping("/prod/spRecList.Ajax") // 반제품 입고 내역
	public List<ReceiveVO> spRecList(){
		List<ReceiveVO> list = service.spRecList();
		return list;
	}
	
	@ResponseBody
	@PostMapping("/prod/spRec.Ajax") // 반제품 입고
	public List<ReceiveVO> spRec(@RequestBody List<ReceiveVO> list, Principal principal){
		String id = principal.getName();
		for(ReceiveVO vo : list) {
			vo.setEmpId(id);
		}
		return service.spRec(list);
	}
	
	// 반제품 입고 조회
	@GetMapping("prod/spRecInfo")
	public void spRecInfo() {
	}
	
	@ResponseBody
	@PostMapping("/prod/spRecSearch.Ajax") // 공정실적 검색
	public List<ReceiveVO> spRecSearch(ReceiveVO vo){
		return service.spRecSearch(vo);
	}
	
	
	// 완제품 입고 관리
	
	@GetMapping("prod/cpRec")
	public void cpRec() { // 완제품 입고 페이지 띄우기
	}
	
	@ResponseBody
	@GetMapping("/prod/readyCpList.Ajax") // 완제품 입고 대기 리스트
	public List<ReceiveVO> readyCpList(){
		List<ReceiveVO> list = service.readyCpList();
		System.out.println(list);
		return list;
	}
	
	@ResponseBody
	@GetMapping("/prod/cpRecList.Ajax") // 완제품 입고 내역
	public List<ReceiveVO> cpRecList(){
		List<ReceiveVO> list = service.cpRecList();
		return list;
	}
	
	@ResponseBody
	@PostMapping("/prod/cpRec.Ajax") // 완제품 입고
	public List<ReceiveVO> cpRec(@RequestBody List<ReceiveVO> list, Principal principal){
		String id = principal.getName();
		for(ReceiveVO vo : list) {
			vo.setEmpId(id);
		}
		return service.cpRec(list);
	}
	
	
	// 공정 실적 조회
	@GetMapping("/work/performanceInfo") // 공정실적 페이지 띄우기
	public void performanceInfo(Model model) {
		String key = "proc_type";
		model.addAttribute("types", basicService.getComList(key));
	}
	
	@ResponseBody
	@GetMapping("/work/performanceList.Ajax") // 공정실적 목록
	public List<PfmcVO> performanceList(){
		return service.performanceList();
	}
	
	@ResponseBody
	@PostMapping("/work/searchPerformance.Ajax") // 공정실적 검색
	public List<PfmcVO> searchPerformance(PfmcVO vo){
		System.out.println(vo);
		return service.searchPerformance(vo);
	}
	
	// 품질 검사항목 관리
	@GetMapping("/quality/InspList")
	public void inspList() { // 화면 띄우기
	}
	
	@ResponseBody
	@GetMapping("/quality/getInspList.Ajax")
	public List<QilVO> getInspList(){ // 품질검사 항목 목록
		return service.getInspList();
	}
	
	@ResponseBody
	@PostMapping("/quality/addInspList.Ajax")
	public QilVO addInsp(QilVO vo) { // 품질검사 항목 등록
		service.addInsp(vo);
		return vo;
	}
	
	@ResponseBody
	@PostMapping("/quality/updateInspList.Ajax")
	public QilVO upodateInsp(QilVO vo) { // 품질검사 항목 수정
		service.updateInsp(vo);
		return vo;
	}
	
	// 판매실적 조회
	@GetMapping("/sales/salesInfo")
	public void sales() {
	}
	
	@ResponseBody
	@GetMapping("/sales/getSalePrice.Ajax")
	public String getSalePrice(SalesVO vo){
		return service.getSalesInfo(vo);
	}
	
	@ResponseBody
	@GetMapping("/sales/getSaleCount.Ajax")
	public String getSaleCount(SalesVO vo){
		return service.getSalesCount(vo);
	}
	
	@ResponseBody
	@GetMapping("/sales/getMonthlySales.Ajax")
	public String getMonthlySales(SalesVO vo){
		return service.getMonthlySales(vo);
	}
	
}
