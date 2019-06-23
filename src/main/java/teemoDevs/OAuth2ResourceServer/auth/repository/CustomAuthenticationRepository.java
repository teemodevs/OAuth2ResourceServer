package teemoDevs.OAuth2ResourceServer.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import teemoDevs.OAuth2ResourceServer.auth.domain.CustomAuthentication;

@Repository
public interface CustomAuthenticationRepository extends JpaRepository<CustomAuthentication, Long> {
    CustomAuthentication getOneByEmail(String email);
    CustomAuthentication getOneByName(String name);
}
