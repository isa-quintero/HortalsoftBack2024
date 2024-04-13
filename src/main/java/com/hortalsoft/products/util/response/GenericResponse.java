package com.hortalsoft.products.util.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> implements Serializable {
    private static final long serialVersionUID = 2150687141828922398L;
    private transient T data;
}
