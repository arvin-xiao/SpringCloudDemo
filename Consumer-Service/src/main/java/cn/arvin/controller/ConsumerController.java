package cn.arvin.controller;

import cn.arvin.Pojo.User;
import cn.arvin.Service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Administrator
 * @Date 2018-07-12
 */
@RestController
@RequestMapping("consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping()
    public List<User> queryUserByIds(@RequestParam("ids")List<Long> ids){
        List<User> userList = consumerService.queryUserById(ids);
        return userList;
    }

}
