package cn.arvin.feignConfig;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Administrator
 * @Date 2018-07-14
 */
@Configuration
public class LogConfig {

    @Bean
    Logger.Level feignLoggerConfig(){
        return Logger.Level.FULL;
    }
}
