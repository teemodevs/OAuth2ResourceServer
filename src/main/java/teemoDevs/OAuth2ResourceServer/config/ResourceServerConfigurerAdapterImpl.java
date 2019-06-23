package teemoDevs.OAuth2ResourceServer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer // 자원서버 설정
public class ResourceServerConfigurerAdapterImpl extends ResourceServerConfigurerAdapter {

    // yml에 있는 값을 읽어옴
    @Value("${security.oauth2.resource.token-info-uri}")
    private String checkTokenEndpointUrl;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/me").access("#oauth2.hasScope('read')");

        // h2 콘솔 X-Frame-Options in Spring Security 중지
        http
                .headers().frameOptions().disable();
    }

    @Primary
    @Bean
    public RemoteTokenServices tokenService() {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(checkTokenEndpointUrl);
        tokenService.setClientId("foo");
        tokenService.setClientSecret("bar");
        return tokenService;
    }
}
