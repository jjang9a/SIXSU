package co.sixsu.app;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.sixsu.app.basic.domain.EmpVO;
import co.sixsu.app.basic.mapper.BasicMapper;
import co.sixsu.app.basic.service.BasicService;
import lombok.extern.log4j.Log4j2;


@SpringBootTest
@Log4j2
public class CommonTest {

	@Autowired BasicMapper mapper;
	@Autowired BasicService service;
	
	@Test
	public void getDateTest() {
		Date date = mapper.getDate();
		log.debug(date);
		System.out.println(date);
	}
	
	@Test
	public void serviceTest() {
		List<EmpVO> list = service.getEmpList();
		System.out.println(list);
	}
	
	public void getEmpListTest() {
		List<EmpVO> list = mapper.empList();
		System.out.println(list);
	}
}
