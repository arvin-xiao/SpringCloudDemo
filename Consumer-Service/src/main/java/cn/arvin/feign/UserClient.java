package cn.arvin.feign;

import cn.arvin.Pojo.User;
import cn.arvin.feignConfig.LogConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Author Administrator
 * @Date 2018-07-14
 */
@FeignClient(value = "User-Service",path = "user",
        fallback = UserClientFallBack.class, configuration = LogConfig.class)
                                        //配置获取请求的信息
public interface UserClient {
    @GetMapping("/{id}")
    User queryUserById(@PathVariable("id")Long id);
}
