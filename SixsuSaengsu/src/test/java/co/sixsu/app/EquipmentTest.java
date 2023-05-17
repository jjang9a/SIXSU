package co.sixsu.app;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import co.sixsu.app.domain.equipment.EquConVO;
import co.sixsu.app.service.EquService;

@SpringBootTest
public class EquipmentTest {

	
	@Autowired EquService equService;
	@Test
	void equConList() {
		List<EquConVO> list = equService.equConList();
		System.out.println(list);
	}
}
