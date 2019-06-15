package teemoDevs.OAuth2ResourceServer.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

	// Client로 부터 받은 요청이 인증되었을 때,
	// Principal.getName()을 기반으로 유저 데이터를 쿼리해서 커스텀 데이터로 반환
	@RequestMapping("/me")
	public Authentication user(Principal principal, Authentication authentication) {
		System.out.println("principal.toString() : " + principal.toString());
		System.out.println("principal.getName() : " + principal.getName());

		System.out.println("authentication.toString() : " + authentication.toString());
		System.out.println("authentication.getAuthorities() : " + authentication.getAuthorities());
		System.out.println("authentication.getCredentials() : " + authentication.getCredentials());
		System.out.println("authentication.getDetails() : " + authentication.getDetails());
		System.out.println("authentication.getPrincipal() : " + authentication.getPrincipal());
		System.out.println("authentication.isAuthenticated() : " + authentication.isAuthenticated());

		return authentication;
	}
}
