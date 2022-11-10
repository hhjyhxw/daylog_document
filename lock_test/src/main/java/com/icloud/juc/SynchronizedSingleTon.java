package com.icloud.juc;

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
