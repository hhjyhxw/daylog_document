package com.icloud.core.entity;

/**
 * @author zdh
 */
public interface NetClient {

    /**
     *
     * @param data  待发送数据
     * @param sinfo 服务器信息
     * @return
     * @throws Throwable
     */
    byte[] sendRequest(byte[] data, ServiceInfo sinfo) throws Throwable;
}