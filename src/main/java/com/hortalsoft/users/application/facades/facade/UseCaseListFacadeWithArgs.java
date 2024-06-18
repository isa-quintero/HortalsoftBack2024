package com.hortalsoft.users.application.facades.facade;

import java.util.List;

public interface UseCaseListFacadeWithArgs<T> {
    List<T> execute(T dto);
}
