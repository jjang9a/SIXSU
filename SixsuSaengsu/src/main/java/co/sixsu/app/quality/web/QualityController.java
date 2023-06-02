package co.sixsu.app.quality.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.quality.domain.PrdInspVO;
import co.sixsu.app.quality.domain.QuaVO;
import co.sixsu.app.quality.domain.ShipInspVO;
import co.sixsu.app.quality.service.QualityService;
import co.sixsu.app.work.domain.DetaWorkOrdrVO;

//조민경 - 품질 관리 컨트롤러
@Controller
public class QualityController {

	@Autowired
	QualityService quaService;

	// 도착 자재 관리 페이지
	@GetMapping("/quality/arr")
	public void arr() {
	}

	// 자재 입고 검사 페이지
	@GetMapping("/quality/recInsp")
	public void recInsp() {
	}

	// 공정 검사 페이지
	@GetMapping("/quality/prInsp")
	public void prInsp() {
	}

	// 완제품 출고 검사 페이지
	@GetMapping("/quality/psInsp")
	public void psInsp() {
	}

	// 반품 검사 페이지
	@GetMapping("/quality/returnInsp")
	public void returnInsp() {
	}

	// 입고 검사 조회 페이지
	@GetMapping("/quality/recInspInq")
	public void recInspInq() {
	}
	
	// 공정 검사 조회 페이지

	// 입고 검사 대기 등록 리스트
	@ResponseBody
	@RequestMapping("/quality/proRecList")
	public List<QuaVO> proRecList() {
		List<QuaVO> prList = quaService.proRecList();
		return prList;
	}

	// 자재 입고 검사 등록 (프로시저 사용)
	@ResponseBody
	@PostMapping("/quality/prRegister")
	public List<QuaVO> prRegister(@RequestBody List<QuaVO> list) {
		System.out.println(list);
		quaService.insertpro(list);
		return list;
	}

	// 입고 검사 대기 리스트
	@ResponseBody
	@RequestMapping("/quality/prInspList")
	public List<QuaVO> prInspList() {
		List<QuaVO> priList = quaService.prInspList();
		System.out.println("리스트 출력 확인:" + priList);
		return priList;
	}

	// 입고 검사 항목 불러오기
	@ResponseBody
	@RequestMapping("/quality/inspItem")
	public List<QuaVO> inspItem(String matId) {
		List<QuaVO> list = quaService.inspItem(matId);
		return list;
	}

	// 수정 시 입고 검사 항목 불러오기
	@ResponseBody
	@RequestMapping("/quality/modInspItem")
	public List<QuaVO> modInspItem(String inspNum) {
		List<QuaVO> list = quaService.modInspItem(inspNum);
		System.out.println("수정 항목 출력:" + list);
		return list;
	}

	// 검사 결과 등록 => 검사 세부 insert
	@ResponseBody
	@PostMapping("/quality/priRegister")
	public int priRegister(@RequestBody List<QuaVO> list) {
		System.out.println(list);
		// return quaService.insertPri(list);insertQuaDet(List<QuaVO> list)
		return quaService.insertQuaDet(list);
	}

	// 검사 결과 등록 시 검사 공통 업데이트
	@ResponseBody
	@PostMapping("/quality/priRegUpdate")
	public boolean qComUpdate(QuaVO qua) {
		System.out.println(qua);
		boolean result = quaService.priRegUpdate(qua);
		return result;
	}

	// 입고 검사 완료 리스트(2주 이내의 정보)
	@ResponseBody
	@RequestMapping("/quality/rAfterList")
	public List<QuaVO> rAfterList() {
		List<QuaVO> raList = quaService.afterReqList();
		System.out.println("리스트 출력 확인:" + raList);
		return raList;
	}

	// 입고 검사 완료 삭제
	@ResponseBody
	@RequestMapping("/quality/delReqInsp")
	public boolean delReqInsp(@RequestParam String inspNum) {
		boolean result = quaService.delReqInsp(inspNum);
		return result;
	}

	// 수정 시 qua_details 업데이트
	@ResponseBody
	@PostMapping("/quality/updateQd")
	public List<QuaVO> updateQd(@RequestBody List<QuaVO> list) {
		System.out.println("검사상세업데이트" + list);
		return quaService.updateQd(list);
	}

	// 제품 품질 관리 - 검사 등록 리스트 출력
	@ResponseBody
	@GetMapping("/quality/bpAddList")
	public List<DetaWorkOrdrVO> bpList() {
		List<DetaWorkOrdrVO> list = quaService.bpAddList();
		return list;
	}

	// 공정 검사 등록
	@ResponseBody
	@PostMapping("/quality/bpdAdd")
	public int bpdAdd(@RequestBody List<PrdInspVO> list) {
		System.out.println(list);

		return quaService.bpdAdd(list);
	}

	// 제품 품질 관리 검사 대기 리스트
	@ResponseBody
	@GetMapping("/quality/prwList")
	public List<PrdInspVO> prwList() {
		List<PrdInspVO> list = quaService.prwList();

		return list;

	}

	// 제품 품질 검사 완료 리스트
	@ResponseBody
	@GetMapping("/quality/prdComList")
	public List<PrdInspVO> prdComList() {
		return quaService.prdComList();
	}

	// 출고 검사 목록 리스트
	@ResponseBody
	@GetMapping("/quality/shInspList")
	public List<ShipInspVO> shInspList() {
		return quaService.shInspList();
	}

	// 출고 검사 결과 등록
	@ResponseBody
	@PostMapping("/quality/shipInspAdd")
	public ShipInspVO shipInspAdd(ShipInspVO ship) {
		System.out.println("출고 검사 등록");
		quaService.shipInspAdd(ship);
		System.out.println(ship);
		return ship;
	}
	
	// 출고 검사 결과 수정
	@ResponseBody
	@PostMapping("/quality/shipInspMod")
	public ShipInspVO shipInspMod(ShipInspVO ship) {
		quaService.shipInspMod(ship);
		return ship;
	}
	
	// 반품 검사 목록 리스트
	
	// 반품 검사 결과 등록
	
	// 반품 검사 결과 수정
	
	// 조회 아작스
	@ResponseBody
	@PostMapping("/quality/searchInsp")
	public List<QuaVO> searchInsp(QuaVO vo) {
		return quaService.searchInsp(vo);
	}
	
}
