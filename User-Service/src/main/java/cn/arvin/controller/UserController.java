package cn.arvin.controller;

import cn.arvin.pojo.User;
import cn.arvin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Administrator
 * @Date 2018-07-12
 */

    @RestController
    @RequestMapping("user")
    public class UserController {

        @Autowired
        private UserService userService;

        @GetMapping("/{id}")
        public User queryById(@PathVariable("id") Long id) {
            return this.userService.queryById(id);
        }
    }

