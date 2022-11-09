package com.icloud.core.entity;

import lombok.Data;

/**
 * @author zdh
 */
@Data
public class ServiceInfo {

    /**服务名称*/
    private String name;

    /**服务协议*/
    private String protocol;

    /**服务地址*/
    private String address;
}
