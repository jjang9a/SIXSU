package co.sixsu.app;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.sixsu.app.material.domain.MatreqVO;
import co.sixsu.app.material.mapper.MaterialsMapper;

@SpringBootTest
public class MaterialsTest {
	
	@Autowired MaterialsMapper mapper;
	
	@Test
	void MatRecList() {
		//List<MatreqVO> list = mapper.getMatRecList();
		//System.out.println(list);
	}
}
