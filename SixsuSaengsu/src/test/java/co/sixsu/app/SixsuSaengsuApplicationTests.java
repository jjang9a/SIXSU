package co.sixsu.app;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SixsuSaengsuApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	StringEncryptor jasyptStringEncryptor;
	
	@Test
	public void jaypt_test() {
		String[] plainTextList = { "jdbc:oracle:thin:@13.209.152.93/xe",
									"sixsu", 
									"sense"				
								};
		for(String plainText : plainTextList) {
			String encyptText = jasyptStringEncryptor.encrypt(plainText);
			System.out.println(encyptText);
		}
	}
}
