package cn.arvin.Service;

import cn.arvin.Pojo.User;
import cn.arvin.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Administrator
 * @Date 2018-07-13
 */
@Service
public class ConsumerService {

//    @Autowired
//    private ConsumerDao consumerDao;

    //使用接口动态代理 ConsumerDao的访问方式
    @Autowired
    private UserClient userClient;

    public List<User> queryUserById(List<Long> ids){

        ArrayList<User> users = new ArrayList<>();

        //lambda遍历数组获取用户并添加到集合中
        ids.forEach(id ->users.add(userClient.queryUserById(id)));

        return users;
    }
}
