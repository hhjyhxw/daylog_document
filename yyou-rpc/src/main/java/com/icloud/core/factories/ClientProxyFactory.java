package com.icloud.core.factories;





import com.icloud.core.entity.NetClient;
import com.icloud.core.entity.NettyClient;
import com.icloud.core.entity.ServiceInfoDiscoverer;
import com.icloud.core.entity.ZookeeperServiceInfoDiscoverer;
import com.icloud.core.handers.ClientInvocationHandler;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class ClientProxyFactory {

    //服务发现
    private ServiceInfoDiscoverer serviceInfoDiscoverer= new ZookeeperServiceInfoDiscoverer();


    //代理对象缓存，避免每次都新建
    private Map<Class<?>, Object> objectCache = new HashMap<>();

    //通信客户端，用于发送请求
    private NetClient netClient = new NettyClient();


    public <T> T getProxy(Class<T> interf) {
        T obj = (T) this.objectCache.get(interf);
        if (obj == null) {
            obj = (T) Proxy.newProxyInstance(interf.getClassLoader(), new Class<?>[] { interf },
                    new ClientInvocationHandler(interf, serviceInfoDiscoverer, netClient));
            this.objectCache.put(interf, obj);
        }
        return obj;
    }

}
