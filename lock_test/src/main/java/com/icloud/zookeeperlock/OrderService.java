package com.icloud.zookeeperlock;


import lock.Lock;

/**
 * Runnable模拟并发编程
 */

public class OrderService implements Runnable {

    private OrderNumGenerator orderNumGenerator = new OrderNumGenerator();

    private Lock lock = new ZookeeperDistrbuteLock();

    public void run() {
        try {
            lock.getLock();
            getNumber();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unLock();
        }
    }


    public void getNumber(){
        String orderNo = orderNumGenerator.getNumber();
        System.out.println(Thread.currentThread().getName() + ",orderNo=======>:" + orderNo);
    }


    public static void main(String[] args) {
        System.out.println("--------------模拟生成订单号开始--------------");
        for (int i = 1; i <10 ; i++) {
            new Thread(new OrderService()).start();
        }
    }
}

