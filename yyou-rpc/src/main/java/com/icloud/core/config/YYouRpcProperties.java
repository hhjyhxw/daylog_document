package com.icloud.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zdh
 */
@Data
@ConfigurationProperties(prefix = "yyou-rpc",ignoreInvalidFields = true)
public class YYouRpcProperties {

    private Discovery discovery;


    @Data
    static public class Discovery{
        /**
         * 注册中心地址
         */
        private String serverAaddr;
    }

}
