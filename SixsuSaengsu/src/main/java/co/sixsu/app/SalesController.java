package co.sixsu.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import co.sixsu.app.domain.common.EmpVO;
import co.sixsu.app.mapper.SaleMapper;

@Controller
public class SalesController {
	
	@Autowired
	private SaleMapper mapper;
	
	
 @GetMapping("/sales/invoice")
 public String invoice() {
	 return "/sales/invoice";
 }
 @GetMapping("/sales/customer")
 public String customer() {
	 return "/sales/customer";
 }

 @GetMapping("/sales/employee")
 public String employee() {
	 return "/sales/employee";
 }
@ResponseBody
@RequestMapping("/sales/employees")
public List<EmpVO>  employee(Model modal) {
	 List<EmpVO> list = mapper.empList();
	 modal.addAttribute("list", list);
	 return list;
 }
}
