package com.icloud.core.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ServiceObject {

    private String name;

    /**调用业务beanClass*/
    private Class<?> interf;

    private Object obj;
}

