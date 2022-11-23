package org.example.proxy.cglibproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zdh
 */
public class CarProxyInterceptor implements MethodInterceptor {
    /**
     * @param proxy 代理对象
     * @param method 目标方法
     * @param args 方法参数
     * @param methodProxy 代理对象中 代理方法对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("执行之前....");
        Object rtnObj = methodProxy.invokeSuper(proxy, args);
        System.out.println("执行之后....");
        return rtnObj;
    }
}
