package co.sixsu.app.basic.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.basic.domain.ReceiveVO;
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
	
	
	// 공정 실적 조회
	@GetMapping("/work/performanceInfo") // 공정실적 페이지 띄우기
	public void performanceInfo(Model model) {
		String key = "proc_type";
		model.addAttribute("types", basicService.getComList(key));
	}
	
	@ResponseBody
	@GetMapping("/work/performanceList") // 공정실적 목록
	public List<PfmcVO> performanceList(){
		return service.performanceList();
	}
	
	@ResponseBody
	@PostMapping("/work/searchPerformance") // 공정실적 검색
	public List<PfmcVO> searchPerformance(PfmcVO vo){
		System.out.println(vo);
		return service.searchPerformance(vo);
	}
	
	// 품질 검사항목 관리
	@GetMapping("/quality/inspList")
	public void inspList() { // 화면 띄우기
	}
	
	@ResponseBody
	@GetMapping("/quality/getInspList")
	public List<QilVO> getInspList(){ // 품질검사 항목 목록
		return service.getInspList();
	}
	
	@ResponseBody
	@PostMapping("/quality/addInspList")
	public QilVO addInsp(QilVO vo) { // 품질검사 항목 등록
		service.addInsp(vo);
		return vo;
	}
	
	@ResponseBody
	@PostMapping("/quality/updateInspList")
	public QilVO upodateInsp(QilVO vo) { // 품질검사 항목 수정
		service.updateInsp(vo);
		return vo;
	}
	
}
