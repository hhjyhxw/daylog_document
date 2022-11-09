package com.icloud.core.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zdh
 */
@AllArgsConstructor
@Configuration
@EnableConfigurationProperties(YYouRpcProperties.class)
public class YYouRpcConfig {

}
