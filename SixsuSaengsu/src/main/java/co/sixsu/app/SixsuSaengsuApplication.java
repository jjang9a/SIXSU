package co.sixsu.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
@MapperScan(basePackages = "co.sixsu.app.**.mapper")
public class SixsuSaengsuApplication {

	public static void main(String[] args) {
		SpringApplication.run(SixsuSaengsuApplication.class, args);
	}

	@GetMapping("/top")
	public void top() {
	}
	
	@GetMapping("/")
	public String index() {
		return "login";
	}

}
