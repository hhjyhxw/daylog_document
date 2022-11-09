package com.icloud.zookeeperlock;


import org.I0Itec.zkclient.IZkDataListener;

import java.util.concurrent.CountDownLatch;


/**
 * @author zdh
 */
public class ZookeeperDistrbuteLock extends ZookeeperAbstractLock {


    @Override
    public boolean tryLock() {
        try {
            //创建临时节点成功，返回true
            zkClient.createEphemeral(PATH);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void waitLock() {
        // 使用事件监听，获取到节点被删除
        IZkDataListener iZkDataListener = new IZkDataListener(){
            public void handleDataChange(String s, Object o) throws Exception {

            }

            public void handleDataDeleted(String s) throws Exception {
                if(countDownLatch!=null){
                    countDownLatch.countDown();
                }
            }
        };

        zkClient.subscribeDataChanges(PATH,iZkDataListener);
        if(zkClient.exists(PATH)){
            countDownLatch=new CountDownLatch(1);
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        zkClient.unsubscribeDataChanges(PATH,iZkDataListener);
    }
}

