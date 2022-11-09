package com.icloud.core.entity;

import com.alibaba.fastjson.JSON;
import com.icloud.core.config.YYouRpcProperties;
import org.I0Itec.zkclient.ZkClient;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * 基于zookeeper 作为注册中心的服务发现
 * @author zdh
 */
public class ZookeeperServiceInfoDiscoverer implements ServiceInfoDiscoverer{

    ZkClient client;

    private String centerRootPath = "/you-rpc";

    public ZookeeperServiceInfoDiscoverer(YYouRpcProperties properties) {
        //示例代码，配置信息直接写代码里了，实际应该写在配置文件里
        //String addr = "10.18.51.105:2181";
        String addr = properties.getDiscovery().getServerAaddr();
        client = new ZkClient(addr);
        client.setZkSerializer(new DefaultZkSerializer());
    }


    @Override
    public List<ServiceInfo> getServiceInfo(String name) {
        String servicePath = centerRootPath + "/" + name + "/service";
        List<String> children = client.getChildren(servicePath);
        List<ServiceInfo> resources = new ArrayList<>();
        for (String ch : children) {
            try {
                String deCh = URLDecoder.decode(ch, "UTF-8");
                ServiceInfo r = JSON.parseObject(deCh, ServiceInfo.class);
                resources.add(r);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return resources;
    }
}
