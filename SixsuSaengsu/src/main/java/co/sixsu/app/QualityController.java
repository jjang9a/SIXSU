package co.sixsu.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
@MapperScan(basePackages = "co.sixsu.app.**.mapper")
public class QualityController {
	
	@GetMapping("quality/arr")
	public void arr() { // 도착 자재 관리
	}

}
