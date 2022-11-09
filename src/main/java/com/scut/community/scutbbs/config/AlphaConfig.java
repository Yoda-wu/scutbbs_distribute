package com.scut.community.scutbbs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

/**
 * @author wuyuda
 * @date 2022-11-08 21:09
 * 配置类，可以用来定义第三方的bean， 类似Mybatis
 *
 */
@Configuration
public class AlphaConfig {

    /**
     * 方法名就是bean的名字
     * @return SimpleDateFormat
     */
    @Bean
    public SimpleDateFormat simpleDateFormat(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }
}
