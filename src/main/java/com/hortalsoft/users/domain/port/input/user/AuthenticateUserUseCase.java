package com.hortalsoft.users.domain.port.input.user;


import java.util.Map;

public interface AuthenticateUserUseCase {
    Map<String, String> execute(String idToken);
}
