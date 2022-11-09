package com.icloud.core.entity;

import lombok.Data;

@Data
public class Request {

    /**
     * 调用服务名称
     */
    private String serviceName;

    /**
     * 目标方法名称
     */
    private String method;

    /**
     * 目标方法参数类型列表
     */
    private Class<?> parameterTypes;

    /**
     * 实际参数列表
     */
    private Object[] parameters;
}
