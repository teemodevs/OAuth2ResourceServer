package teemoDevs.OAuth2ResourceServer.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomAuthentication implements Authentication {
    @Transient
    @JsonIgnore
    private Authentication authentication;

    private String email;

    public CustomAuthentication(Authentication authentication) {
        this.authentication = authentication;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authentication.getAuthorities();
    }

    @Override
    public Object getCredentials() {
        return authentication.getCredentials();
    }

    @Override
    public Object getDetails() {
        return authentication.getDetails();
    }

    @Override
    public Object getPrincipal() {
        return authentication.getPrincipal();
    }

    @Override
    public boolean isAuthenticated() {
        return authentication.isAuthenticated();
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        authentication.setAuthenticated(isAuthenticated);
    }

    @Override
    public String getName() {
        return authentication.getName();
    }
}
