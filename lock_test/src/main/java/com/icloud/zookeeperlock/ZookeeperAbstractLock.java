package com.icloud.zookeeperlock;

import lock.Lock;
import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.CountDownLatch;

/**
 * @author zdh
 */
public abstract class ZookeeperAbstractLock implements Lock   {

    /**
     * zk服务器地址
     */
    private static final String CONNECTSTRING="106.12.123.38:2181";


    /**
     * // 连接zookeepe
     */
    protected ZkClient zkClient=new ZkClient(CONNECTSTRING);

    /**创建节点路径*/
    protected static String PATH="/lock";

    /**倒计时器作用线程阻塞*/
    protected CountDownLatch countDownLatch;

    public void getLock() {
        if(tryLock()){
            System.out.println("---------------获取锁成功---------------");
        }else {
            waitLock();
            getLock(); //自己调自己
        }
    }

    public void unLock() {
        if(zkClient!=null){
            zkClient.close();
            System.out.println("---------------释放资源---------------");
        }
    }


    /**
     * 是否获取锁成功
     * @return
     */
    public abstract boolean tryLock();

    /**
     * 等待锁
     */
    public abstract void waitLock();
}
