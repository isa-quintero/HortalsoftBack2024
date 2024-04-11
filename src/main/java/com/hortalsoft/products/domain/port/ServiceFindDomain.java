package com.hortalsoft.products.domain.port;

public interface ServiceFindDomain <D,E>{
    E execute(D domain);
}
