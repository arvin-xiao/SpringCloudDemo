package eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @Author Administrator
 * @Date 2018-07-13
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication2.class,args);
    }
}
