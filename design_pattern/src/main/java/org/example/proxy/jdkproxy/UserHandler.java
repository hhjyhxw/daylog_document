package org.example.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author zdh
 */
public class UserHandler implements InvocationHandler {

    /**需要有一个成员变量，成员变量为被代理对象，通过构造参数传入，用来支持方法的反射调用。*/
    private Object obj;
    /**需要有一个有参构造，通过构造函数将被代理对象的实例传入，用来支持方法的反射调用*/
    public UserHandler(Object obj) {
        this.obj = obj;
    }

    /**
     * @param proxy 动态生成的代理类型 com.sun.proxy.$Proxy0
     * @param method 被代理对象的真实方法的 Method 对象
     * @param args  调用方法时的入参
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /**目标方法执行前的自定义逻辑处理*/
        System.out.println("-----before------");
        /**执行目标对象的方法，使用反射来执行方法，反射需要传入目标对象，此时用到了成员变量obj。*/
        Object result = method.invoke(obj, args);
        /**目标方法执行后的自定义逻辑处理*/
        System.out.println("-----after------");
        return result;
    }
}
