package com.hortalsoft.users.domain.port.usecase.user;

import com.hortalsoft.users.domain.port.input.UseCaseDomain;
import org.springframework.stereotype.Service;


@Service
public abstract class AbstractUserService<T> implements UseCaseDomain<T> {
    public abstract void execute(T input);
}