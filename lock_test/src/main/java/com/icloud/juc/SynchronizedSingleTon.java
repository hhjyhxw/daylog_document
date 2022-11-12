package com.icloud.juc;

import jdk.nashorn.internal.objects.annotations.Function;

/**
 * @author zdh
 */
public class SynchronizedSingleTon {

    /**
     *  1、保证内存可见性
     *  2、禁止指令重排序
     */
    public static volatile SynchronizedSingleTon  INSTANCE = null;

    public static SynchronizedSingleTon getInstance(){
        if(INSTANCE==null){
            synchronized (SynchronizedSingleTon.class){
                if(INSTANCE==null){
                    INSTANCE = new SynchronizedSingleTon();
                }
            }
        }
        return INSTANCE;
    }


}
