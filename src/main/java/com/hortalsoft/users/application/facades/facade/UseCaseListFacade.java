package com.hortalsoft.users.application.facades.facade;

import java.util.List;

public interface UseCaseListFacade<T> {
    List<T> execute();
}
