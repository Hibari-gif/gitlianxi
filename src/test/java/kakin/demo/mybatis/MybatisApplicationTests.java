package kakin.demo.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class MybatisApplicationTests {

	@Test
	void contextLoads() {
	}

    @Test
    void encode() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("123456");
        String password2 = bCryptPasswordEncoder.encode("1234567");
        System.out.println("password:" + password);
        System.out.println("password:" + password2);
    }
}
