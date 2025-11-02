package com.sky.config;

import com.sky.properties.AliOssProperties;
import com.sky.utils.AliOssUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class OssConfiguration {


    private final AliOssProperties aliOssProperties;

    public OssConfiguration(AliOssProperties aliOssProperties) {
        this.aliOssProperties = aliOssProperties;
    }

    @Bean
    @ConditionalOnMissingBean
    public AliOssUtil aliOssUtil(){
        log.info("开始创建阿里云文件上传工具类：{}",aliOssProperties);
        return new AliOssUtil(aliOssProperties.getEndpoint(),
                aliOssProperties.getAccessKeyId(),
                aliOssProperties.getAccessKeySecret(),
                aliOssProperties.getBucketName());
    }
}
