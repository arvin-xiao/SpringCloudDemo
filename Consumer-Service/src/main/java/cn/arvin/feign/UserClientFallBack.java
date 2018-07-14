package cn.arvin.feign;

import cn.arvin.Pojo.User;
import org.springframework.stereotype.Component;

/**
 * @Author Administrator
 * @Date 2018-07-14
 */
@Component
public class UserClientFallBack implements UserClient{
    @Override
    public User queryUserById(Long id) {
        User user = new User();
        user.setNote("feign的熔断方法");
        return user;
    }
}
