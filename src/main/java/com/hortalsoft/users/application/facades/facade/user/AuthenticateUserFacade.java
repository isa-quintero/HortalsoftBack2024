package com.hortalsoft.users.application.facades.facade.user;


import java.util.Map;

public interface AuthenticateUserFacade {
    Map<String, String> execute(String idToken);
}
