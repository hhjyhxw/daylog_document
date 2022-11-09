package com.icloud.core.handers;

import com.icloud.core.entity.NetClient;
import com.icloud.core.entity.ServiceInfo;
import com.icloud.core.entity.ServiceInfoDiscoverer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

/**
 * @author zdh
 */
public class ClientInvocationHandler implements InvocationHandler {


    private Class<?> interf;
    private ServiceInfoDiscoverer serviceInfoDiscoverer;
    private NetClient netClient;

    private Random random = new Random();

    public <T> ClientInvocationHandler(Class<T> interf, ServiceInfoDiscoverer serviceInfoDiscoverer, NetClient netClient) {
        this.interf = interf;
        this.serviceInfoDiscoverer = serviceInfoDiscoverer;
        this.netClient = netClient;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("toString")) {
            return proxy.getClass().toString();
        }

        if (method.getName().equals("hashCode")) {
            return 0;
        }
        //根据名称去注册中心找到对应的服务
        String serviceName = method.getName();
        List<ServiceInfo> serviceInfos = serviceInfoDiscoverer.getServiceInfo(serviceName);
        //缘分负载均衡
        ServiceInfo serviceInfo = serviceInfos.get(random.nextInt(serviceInfos.size()));

        //TODO: 将请求编组为消息发送到服务端，并读取服务端返回的结果
        return method.invoke(args);
    }

}
