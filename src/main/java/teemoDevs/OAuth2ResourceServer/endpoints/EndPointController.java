package teemoDevs.OAuth2ResourceServer.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teemoDevs.OAuth2ResourceServer.auth.domain.CustomAuthentication;
import teemoDevs.OAuth2ResourceServer.auth.service.CustomAuthenticationService;

import java.security.Principal;

@RestController
public class EndPointController {

	@Autowired
	private CustomAuthenticationService customAuthenticationService;

	// Client로 부터 받은 요청이 인증되었을 때,
	// Principal.getName()을 기반으로 유저 데이터를 쿼리해서 커스텀 데이터로 반환
	@RequestMapping("/me")
	public Authentication user(Principal principal, Authentication authentication) {

		CustomAuthentication customAuthentication
				= customAuthenticationService.getCustomAuthenticationByName(authentication.getName());

		// Client에서는 Resource Server로 부터 유저 정보와 권한 정보를 제공받는다.
		// 단, 권한 정보는 Authorization Server로 부터 제공받은 것을 그대로 전달한다.
		customAuthentication.setAuthentication(authentication);

		System.out.println("----principal----");
		System.out.println("principal.toString() : " + principal.toString());
		System.out.println("principal.getName() : " + principal.getName());
		System.out.println();

		System.out.println("----authentication----");
		System.out.println("authentication.toString() : " + authentication.toString());
		System.out.println("authentication.getAuthorities() : " + authentication.getAuthorities());
		System.out.println("authentication.getCredentials() : " + authentication.getCredentials());
		System.out.println("authentication.getDetails() : " + authentication.getDetails());
		System.out.println("authentication.getPrincipal() : " + authentication.getPrincipal());
		System.out.println("authentication.isAuthenticated() : " + authentication.isAuthenticated());
		System.out.println();

		System.out.println("----custom authentication----");
		System.out.println("customAuthentication.toString() : " + customAuthentication.toString());
		System.out.println("customAuthentication.getName() : " + customAuthentication.getName());
		System.out.println("customAuthentication.getEmail() : " + customAuthentication.getEmail());

		System.out.println("customAuthentication.getAuthentication() : " + customAuthentication.getAuthentication());
		System.out.println("customAuthentication.getAuthorities() : " + customAuthentication.getAuthorities());
		System.out.println("customAuthentication.getCredentials() : " + customAuthentication.getCredentials());
		System.out.println("customAuthentication.getDetails() : " + customAuthentication.getDetails());
		System.out.println("customAuthentication.getPrincipal() : " + customAuthentication.getPrincipal());

		return customAuthentication;
	}
}
