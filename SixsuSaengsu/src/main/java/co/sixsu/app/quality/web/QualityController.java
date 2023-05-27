package co.sixsu.app.quality.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.quality.domain.PrdInspVO;
import co.sixsu.app.quality.domain.QuaVO;
import co.sixsu.app.quality.service.QualityService;
import co.sixsu.app.work.domain.DetaWorkOrdrVO;

@Controller
//@SpringBootApplication
public class QualityController {

	@Autowired
	QualityService quaService;

	// 도착 자재 관리 페이지
	@GetMapping("/quality/arr")
	public void arr() {
	}

	// 도착 자재 리스트
	@ResponseBody
	@RequestMapping("/quality/arrList")
	public List<QuaVO> arrList(Model model) {
		List<QuaVO> list = quaService.getArrList();
		model.addAttribute("arrList", list);
		return list;
	}

	// 자재 도착 등록 대기 리스트
	@ResponseBody
	@RequestMapping("/quality/arrRegList")
	public List<QuaVO> arrRegList(Model model) {
		List<QuaVO> rList = quaService.arrRegList();
		model.addAttribute("regList", rList);
		return rList;
	}

	// 도착 등록
	@ResponseBody
	@PostMapping("/quality/arrRegister")
	public String arrRegister(QuaVO am, MatreqVO mat) {

		quaService.insertArr(am);
		System.out.println(am);
		System.out.println(mat);
		return "redirect:/quality/arrRegList";
	}

	// 자재 입고 검사 페이지
	@GetMapping("/quality/recInsp")
	public void recInsp() {

	}

	// 입고 검사 대기 등록 리스트
	@ResponseBody
	@RequestMapping("/quality/proRecList")
	public List<QuaVO> proRecList(Model model) {
		List<QuaVO> prList = quaService.proRecList();
		model.addAttribute("proRecList", prList);
		return prList;
	}

	// 자재 입고 검사 등록 (프로시저 사용)
	@ResponseBody
	@PostMapping("/quality/prRegister")
	public List<QuaVO> prRegister(@RequestBody List<QuaVO> list) {
		System.out.println(list);
		return quaService.insertpro(list);
	}

	// 입고 검사 대기 리스트
	@ResponseBody
	@RequestMapping("/quality/prInspList")
	public List<QuaVO> prInspList(Model model) {
		List<QuaVO> priList = quaService.prInspList();
		model.addAttribute("priList", priList);
		System.out.println("리스트 출력 확인:" + priList);
		return priList;
	}

	// 입고 검사 항목 불러오기
	@ResponseBody
	@RequestMapping("/quality/inspItem")
	public List<QuaVO> inspItem(Model model, String matId) {
		List<QuaVO> list = quaService.inspItem(matId);
		model.addAttribute("list", list);
		return list;
	}

	// 입고 검사 결과 등록 프로시저
//	@ResponseBody
//	@PostMapping("/quality/priRegister")
//	public List<QuaVO> reqInspProc(@RequestBody List<QuaVO> list) {
//		System.out.println(list);
//		return quaService.reqInspProc(list);
//	}

	// 입고 검사 결과 등록
	@ResponseBody
	@PostMapping("/quality/priRegister")
	public List<QuaVO> priRegister(@RequestBody List<QuaVO> list) {

		System.out.println(list);
		// return quaService.insertPri(list);
		return quaService.insertPriAndUpdate(list);
	}

	// 입고 검사 결과 등록 시 업데이트
	@ResponseBody
	@PostMapping("/quality/priRegUpdate")
	public boolean priRegUpdate(QuaVO qua) {
		boolean result = quaService.priRegUpdate(qua);
		return result;
	}

	// 자재 입고 검사 페이지
	@GetMapping("/quality/prInsp")
	public void prInsp() {

	}

	// 제품 품질 관리 - 검사 등록 리스트 출력
	@ResponseBody
	@GetMapping("/quality/bpAddList")
	public List<DetaWorkOrdrVO> bpList(Model model) {
		List<DetaWorkOrdrVO> list = quaService.bpAddList();
		model.addAttribute("list", list);
		return list;
	}

	// 제품 품질 관리 검사 등록
//	  @ResponseBody
//	  @PostMapping("/quality/pdAdd") 
//	  public List<PrdInspVO> bpdAdd(@RequestBody List<PrdInspVO> list) { 
//		  System.out.println(list);
//		  return quaService.bpdAdd(list); 
//	}
//	 

}
