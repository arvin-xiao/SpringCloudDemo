package cn.arvin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Administrator
 * @Date 2018-07-12
 */
@SpringBootApplication
@MapperScan("cn.arvin.mapper")
@EnableDiscoveryClient
//适用于其他的客户端，扩展性较强
//@EnableEurekaClient仅适用于eureka的客户端
public class UserApplication {
    public static void main(String[] args) {

        SpringApplication.run(UserApplication.class,args);
    }
}
