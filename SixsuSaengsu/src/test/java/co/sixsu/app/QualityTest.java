package co.sixsu.app;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import co.sixsu.app.quality.domain.QuaVO;
import co.sixsu.app.quality.mapper.QualityMapper;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
@ContextConfiguration(classes = SixsuSaengsuApplication.class)
public class QualityTest {
	@Autowired QualityMapper mapper;
	
}
