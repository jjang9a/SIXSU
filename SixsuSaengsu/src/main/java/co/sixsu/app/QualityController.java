package co.sixsu.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import co.sixsu.app.mapper.QualityMapper;

@Controller
@SpringBootApplication
@MapperScan(basePackages = "co.sixsu.app.**.mapper")
public class QualityController {
	
	@Autowired QualityMapper quaMapper;
	
	@GetMapping("quality/arr")
	public void arr() { // 도착 자재 관리
	}
	
	@RequestMapping("quality/arrList")
	public String arrList(Model model) {
		model.addAttribute("arrList", quaMapper.getArrList());
		return "arrList";
	}

}
