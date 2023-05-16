package co.sixsu.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.sixsu.app.mapper.QualityMapper;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
public class QualityTest {
	@Autowired QualityMapper mapper;
	
	
	
}
