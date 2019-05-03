package teemoDevs.OAuth2ResourceServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableResourceServer // 자원서버 설정
@SpringBootApplication
public class OAuth2ResourceServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OAuth2ResourceServerApplication.class, args);
	}

}
