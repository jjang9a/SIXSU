package co.sixsu.app.quality.web;

import java.security.Principal;
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

import co.sixsu.app.basic.service.BasicService;
import co.sixsu.app.quality.domain.PrdInspVO;
import co.sixsu.app.quality.domain.QuaVO;
import co.sixsu.app.quality.domain.ReturnInspVO;
import co.sixsu.app.quality.domain.ShipInspVO;
import co.sixsu.app.quality.service.QualityService;

//조민경 - 품질 관리 컨트롤러
@Controller
public class QualityController {

	@Autowired
	QualityService quaService;
	@Autowired BasicService bservice;

	// 도착 자재 관리 페이지
	@GetMapping("/quality/arr")
	public void arr() {
	}

	// 자재 입고 검사 페이지
	@GetMapping("/quality/recInsp")
	public void recInsp(Model model) {
		model.addAttribute("inspResStat",bservice.commGroupList("INSP_RES_STAT"));
	}

	// 공정 검사 페이지
	@GetMapping("/quality/prInsp")
	public void prInsp(Model model) {
		model.addAttribute("inspResStat",bservice.commGroupList("INSP_RES_STAT"));
	}

	// 완제품 출고 검사 페이지
	@GetMapping("/quality/psInsp")
	public void psInsp(Model model) {
		model.addAttribute("inspResStat",bservice.commGroupList("INSP_RES_STAT"));
	}

	// 반품 검사 페이지
	@GetMapping("/quality/returnInsp")
	public void returnInsp(Model model) {
		model.addAttribute("inspResStat",bservice.commGroupList("INSP_RES_STAT"));
	}


	// 검사 조회 페이지
	@GetMapping("/quality/inspInfo")
	public void recInspInq() {
	}
	

	
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
	public boolean qComUpdate(QuaVO qua, Principal principal) {
		System.out.println(qua);
		String id = principal.getName();
		qua.setEmpId(id);
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

	// 검사 완료 삭제
	@ResponseBody
	@PostMapping("/quality/delInsp")
	public boolean delReqInsp(QuaVO qua) {
		boolean result = quaService.delInsp(qua);
		return result;
	}

	// 수정 시 qua_details 업데이트
	@ResponseBody
	@PostMapping("/quality/updateQd")
	public List<QuaVO> updateQd(@RequestBody List<QuaVO> list) {
		System.out.println("검사상세업데이트" + list);
		return quaService.updateQd(list);
	}

	// 공정 검사 관리 - 검사 등록 리스트 출력
	@ResponseBody
	@GetMapping("/quality/bpAddList")
	public List<PrdInspVO> bpList() {
		List<PrdInspVO> list = quaService.bpAddList();
		return list;
	}

	// 공정 검사 등록
	@ResponseBody
	@PostMapping("/quality/bpdAdd")
	public int bpdAdd(@RequestBody List<PrdInspVO> list) {
		System.out.println(list);

		return quaService.bpdAdd(list);
	}

	// 공정 검사 관리 검사 대기 리스트
	@ResponseBody
	@GetMapping("/quality/prwList")
	public List<PrdInspVO> prwList() {
		List<PrdInspVO> list = quaService.prwList();

		return list;

	}
	
	// 공정 검사 결과 등록
	@ResponseBody
	@PostMapping("/quality/prdComUpdate")
	public boolean prdComUpdate(PrdInspVO prd, Principal principal) {
		System.out.println(prd);
		String id = principal.getName();
		prd.setEmpId(id);
		boolean result = quaService.prdComUpdate(prd);
		return result;
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
	public List<ShipInspVO> shInspList(Model model) {
			model.addAttribute("inspResStat",bservice.commGroupList("INSP_RES_STAT"));
		return quaService.shInspList();
	}

	// 출고 검사 결과 등록
	@ResponseBody
	@PostMapping("/quality/shipInspAdd")
	public ShipInspVO shipInspAdd(ShipInspVO ship, Principal principal) {
		System.out.println("출고 검사 등록");
		String id = principal.getName();
		ship.setEmpId(id);
		quaService.shipInspAdd(ship);
		System.out.println(ship);
		return ship;
	}
	
	// 출고 검사 결과 수정
	@ResponseBody
	@PostMapping("/quality/shipInspMod")
	public ShipInspVO shipInspMod(ShipInspVO ship) {
		System.out.println("수정:"+ship);
		quaService.shipInspMod(ship);
		return ship;
	}
	
	// 출고 검사 결과 삭제
	@ResponseBody
	@PostMapping("/quality/shipInspDel")
	public boolean shipInspDel (QuaVO qua) {
		boolean result = quaService.delShipInsp(qua);
		return result;
	}
	
	// 반품 검사 목록 리스트
	@ResponseBody
	@GetMapping("/quality/returnList")
	public List<ReturnInspVO> returnList() {
		return quaService.returnList();
	}
	
	// 반품 검사 결과 등록
	@ResponseBody
	@PostMapping("/quality/returnInspAdd")
	public ReturnInspVO returnInspAdd(ReturnInspVO ret, Principal principal) {
		System.out.println("반품 검사 등록");
		String id = principal.getName();
		ret.setEmpId(id);
		quaService.returnInspAdd(ret);
		return ret;
	}
	
	// 반품 검사 결과 수정
	@ResponseBody
	@PostMapping("/quality/returnInspMod")
	public ReturnInspVO returnInspMod(ReturnInspVO ret){
		quaService.returnInspMod(ret);
		return ret;
	}
	
	// 반품 검사 결과 삭제
	
	
	// 조회 아작스
	@ResponseBody
	@PostMapping("/quality/searchInsp") // 품질검사 조회
	public List<QuaVO> searchInsp(QuaVO vo) {
		return quaService.searchInsp(vo);
	}
	
	@ResponseBody
	@GetMapping("/quality/waterAjax") // 원천수 입고대기목록
	public List<QuaVO> waterAjax(){
		return quaService.getWater();
	}
	
	@ResponseBody
	@GetMapping("/quality/resultInspList")
	public List<QuaVO> resultInspList(){ // 2주이내 검사결과 리스트
		return quaService.resultInspList();
	}
	
	@ResponseBody
	@GetMapping("/quality/getDetail") // 품질검사 상세결과
	public List<QuaVO> getDetail(@RequestParam String inspNum){
		return quaService.getDetail(inspNum);
	}
}
