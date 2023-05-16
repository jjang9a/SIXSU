package co.sixsu.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalesController {
 @GetMapping("/sales/invoice")
 public String invoice() {
	 return "/sales/invoice";
 }
 @GetMapping("/sales/customer")
 public String customer() {
	 return "/sales/customer";
 }
}
