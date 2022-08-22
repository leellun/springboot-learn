package com.example.zklock.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@EnableConfigurationProperties({ZkProperties.class})
@Configuration
public class ZkConfig {
}
