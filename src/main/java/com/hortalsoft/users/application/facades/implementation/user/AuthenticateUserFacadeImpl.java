package com.hortalsoft.users.application.facades.implementation.user;


import com.hortalsoft.users.application.facades.facade.user.AuthenticateUserFacade;
import com.hortalsoft.users.domain.port.input.user.AuthenticateUserUseCase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Transactional
public class AuthenticateUserFacadeImpl implements AuthenticateUserFacade {
    private final AuthenticateUserUseCase authenticateUserUseCase;

    @Autowired
    public AuthenticateUserFacadeImpl(AuthenticateUserUseCase authenticateUserUseCase) {
        this.authenticateUserUseCase = authenticateUserUseCase;
    }

    @Override
    public Map<String, String> execute(String idToken) {
        return authenticateUserUseCase.execute(idToken);
    }
}
