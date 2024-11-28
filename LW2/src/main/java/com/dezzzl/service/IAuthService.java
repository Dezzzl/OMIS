package com.dezzzl.service;

import com.dezzzl.entity.user.User;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

public interface IAuthService {
    boolean register(User user);

    boolean login(String email, String password);


    boolean logout(OAuth2ResourceServerProperties.Jwt jwt);

    void updateUser(User user);

    void deleteUser(int id);
}
