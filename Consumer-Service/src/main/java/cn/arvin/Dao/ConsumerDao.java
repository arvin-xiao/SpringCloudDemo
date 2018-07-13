package cn.arvin.Dao;

import cn.arvin.Pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2018-07-12
 */
@Component
public class ConsumerDao {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    public User queryUserById(Long id){

        //通过注册的客户端获取客户端实例
        List<ServiceInstance> clientInstances = discoveryClient.getInstances("User-Service");

        //通过负载均衡的算法获取其中一个服务，

        ServiceInstance server = clientInstances.get(0);
        String host = server.getHost();
        int port = server.getPort();
        String url = "http://" + host + ":" + port + "/user/" + id;

        //访问服务器地址
        User user = this.restTemplate.getForObject(url, User.class);
        return user;
    }
}
