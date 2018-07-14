package cn.arvin.Dao;

import cn.arvin.Pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @Author Administrator
 * @Date 2018-07-12
 */
@Component
public class ConsumerDao {

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private DiscoveryClient discoveryClient;

    //熔断指令
    @HystrixCommand(fallbackMethod = "queryUserByIdFallback")
    public User queryUserById(Long id){

        //通过注册的客户端获取客户端实例
//        List<ServiceInstance> clientInstances = discoveryClient.getInstances("User-Service");
//        //通过负载均衡的算法获取其中一个服务，
//        ServiceInstance server = clientInstances.get(0);
//        String host = server.getHost();
//        int port = server.getPort();
//        String url = "http://" + host + ":" + port + "/user/" + id;

        //Ribbon负载均衡自动获取服务列表
        String url = "http://User-Service/user/" + id;
        //访问服务地址
        User user = this.restTemplate.getForObject(url, User.class);
        return user;
    }

    public User queryUserByIdFallback(Long id){
        //可以抛出异常
        User user = new User();
        user.setNote("用户信息查询异常");
        return user;
    }

}
