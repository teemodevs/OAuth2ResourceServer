package teemoDevs.OAuth2ResourceServer.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teemoDevs.OAuth2ResourceServer.auth.domain.CustomAuthentication;
import teemoDevs.OAuth2ResourceServer.auth.repository.CustomAuthenticationRepository;

@Service
public class CustomAuthenticationService {
    @Autowired
    private CustomAuthenticationRepository customAuthenticationRepository;

    public void save(CustomAuthentication customAuthentication) {
        customAuthenticationRepository.save(customAuthentication);
    }

    public CustomAuthentication getCustomAuthenticationByName(String name) {
        return customAuthenticationRepository.getOneByName(name);
    }

    public CustomAuthentication getCustomAuthenticationByEmail(String email) {
        return customAuthenticationRepository.getOneByEmail(email);
    }

}
