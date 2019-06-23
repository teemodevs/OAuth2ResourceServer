package teemoDevs.OAuth2ResourceServer.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teemoDevs.OAuth2ResourceServer.auth.domain.CustomAuthentication;
import teemoDevs.OAuth2ResourceServer.auth.domain.UserRegisterForm;
import teemoDevs.OAuth2ResourceServer.auth.service.CustomAuthenticationService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private CustomAuthenticationService customAuthenticationService;

    @PostMapping("/email/add")
    public ResponseEntity<?> addUserEmail(@RequestBody UserRegisterForm userRegisterForm) {

        System.out.println("username : " + userRegisterForm.getUsername());
        System.out.println("email : " + userRegisterForm.getEmail());

        CustomAuthentication newCustomAuthentication = new CustomAuthentication();

        newCustomAuthentication.setName(userRegisterForm.getUsername());
        newCustomAuthentication.setEmail(userRegisterForm.getEmail());

        customAuthenticationService.save(newCustomAuthentication);

        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/email/checkDuplicated")
    public ResponseEntity<?> checkDuplicatedEmail(@RequestBody String email) {

        System.out.println("email : " + email);
        // 이미 존재하는 이메일인 경우
        if (customAuthenticationService.getCustomAuthenticationByEmail(email) != null)
            return new ResponseEntity(HttpStatus.IM_USED);

        return new ResponseEntity(HttpStatus.OK);

    }
}
