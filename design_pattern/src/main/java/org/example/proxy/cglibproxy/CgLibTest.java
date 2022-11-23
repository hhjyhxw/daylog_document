package org.example.proxy.cglibproxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

/**
 * @author zdh
 */
public class CgLibTest {
    public static void main(String[] args) {
        // 创建空的字节码对象
        Enhancer enhancer = new Enhancer();
        // 设置字节码对象的父类也就是目标类
        enhancer.setSuperclass(Car.class);
        //创建回调对象
        Callback callback = new CarProxyInterceptor();
        // 设置字节码对象的回调方法
        enhancer.setCallback(callback);
        // 得到代理对象
        Car carProxy = (Car) enhancer.create();
        // 调用方法
        carProxy.going();
    }
}
