package com.icloud.core.entity;

import java.util.List;

/**
 * @author zdh
 */
public interface ServiceInfoDiscoverer {

    /**
     *根据服务名称 获取可用服务列表
     * @param name 服务名称
     * @return 服务信息对象列表
     */
    List<ServiceInfo> getServiceInfo(String name);
}
