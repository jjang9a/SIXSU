package co.sixsu.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.domain.equipment.EquContVO;

@Controller
@SpringBootApplication
public class EquipmentController {
	
	
	
	@GetMapping("equ")
	public String equ() {
		System.out.println("테스트입니다.");
		return "/equ";
	}
	
	@GetMapping("equ1")
	public String equ1() {
		System.out.println("테스트1입니다.");
		return "/equ1";
	}
	
}
