package cn.arvin.service.impl;

import cn.arvin.mapper.UserMapper;
import cn.arvin.pojo.User;
import cn.arvin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @Author Administrator
 * @Date 2018-07-12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryById(Long id) {
        // 为了演示超时现象，我们在这里然线程休眠,时间随机 0~2000毫秒
        int time = new Random().nextInt(2000);
        System.out.println("time = " + time);
        try {
            Thread.sleep(Long.valueOf(time+ ""));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userMapper.selectByPrimaryKey(id);
    }
}
