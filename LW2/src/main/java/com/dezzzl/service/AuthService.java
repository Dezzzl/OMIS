package com.dezzzl.service;

import com.dezzzl.entity.user.User;
import com.dezzzl.repository.IAuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthService implements IAuthService {
    private final IAuthRepository authRepository;

    @Override
    public boolean register(User user) {
        authRepository.createUser(user);
        return authRepository.getUser(user.getEmail()) != null;
    }

    @Override
    public boolean login(String email, String password) {
        User user = authRepository.getUser(email);
        return Objects.equals(password, user.getPassword());
    }

    @Override
    public boolean logout(OAuth2ResourceServerProperties.Jwt jwt) {
        return true;
    }

    @Override
    public void updateUser(User user) {
        authRepository.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {

    }
}
