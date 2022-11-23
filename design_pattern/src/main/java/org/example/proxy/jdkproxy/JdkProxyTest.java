package org.example.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author zdh
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        //将生成的代理对象的字节码文件 保存到硬盘
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.err.println("ystem.getProperties()=="+System.getProperties());
        //被代理对象的实例
        UserInterface obj = new UserImpl();
        //通过构造函数,传入被代理对象的实例，生成处理器的实例
        InvocationHandler handler = new UserHandler(obj);
        //通过Proxy.newProxyInstance方法，传入被代理对象Class对象、处理器实例，生成代理对象实例
        UserInterface proxyInstance = (UserInterface) Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                new Class[]{UserInterface.class}, handler);
        //调用生成的代理对象的doSomething方法
        proxyInstance.doSomething();
        System.out.println("===================分割线==================");
        //调用生成的代理对象的saySomething方法
        proxyInstance.saySomething();
    }
}
