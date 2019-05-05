package teemoDevs.OAuth2ResourceServer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

	@RequestMapping("/me")
	public Principal user(Principal principal) {
		return principal;
	}
}
