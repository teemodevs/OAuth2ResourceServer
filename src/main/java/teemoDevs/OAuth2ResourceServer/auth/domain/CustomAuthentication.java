package teemoDevs.OAuth2ResourceServer.auth.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Collection;

/**
 * 커스텀 Authentication
 * 1. /me 엔드포인트의 유저 정보(CustomOAuth2User) DTO
 * 2. {@link Authentication}를 구현하여 Spring Security에 필요한 메서드와 값들을 제공
 * 3. Client에게 부가적인 정보(email 등)를 전송
 * */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomAuthentication implements Authentication {

    @Id
    @GeneratedValue
    private Long id;

    @Transient
    @JsonIgnore
    private Authentication authentication;

    private String name;
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
        if (authentication == null)
            return this.name;
        else
            return authentication.getName();
    }
}
