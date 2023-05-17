package co.sixsu.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.sixsu.app.domain.equipment.EquConVO;
import co.sixsu.app.service.EquService;

@RestController
@RequestMapping("ajax")
public class EquAjaxController {

	@Autowired EquService equService;
	
//	@GetMapping("equAjax")
//	public List toastDataList() {
//		List list = new ArrayList();
//		EquConVO data = new EquConVO("EQU_005", "PROC_005", "가공설비", "MODEL_005", "비가동", "라인 C", "3개월", "가공설비.jpg", "곽호섭");
//		list.add(data);
//		return list;
//	}
	
	@GetMapping("equConList") // 설비관리 목록
	public List<EquConVO> toastDataList1() {
		List<EquConVO> list = equService.equConList();
		return list;
	}
	
	
	
}
