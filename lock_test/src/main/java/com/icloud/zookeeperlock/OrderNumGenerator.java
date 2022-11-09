package com.icloud.zookeeperlock;



import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zdh
 */
public class OrderNumGenerator {

    /**组成订单号的变量*/
    private static int count = 0;

    /**
     * 使用new Date()和count生成订单号
     * @return
     */
    public String getNumber() {
        //时间类型转化
        SimpleDateFormat simpt = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        return simpt.format(new Date()) + "-" + ++count;
    }

}


