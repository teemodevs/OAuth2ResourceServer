package teemoDevs.OAuth2ResourceServer.auth.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterForm {
    private String username;
    private String email;
}
