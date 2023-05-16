package co.sixsu.app;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.sixsu.app.mapper.CommonMapper;
import lombok.extern.log4j.Log4j2;


@SpringBootTest
@Log4j2
public class CommonTest {

	@Autowired CommonMapper mapper;
	
	@Test
	public void getDateTest() {
		Date date = mapper.getDate();
		log.debug(date);
		System.out.println(date);
	}
}
