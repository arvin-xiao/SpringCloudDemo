package cn.arvin.service.impl;

import cn.arvin.mapper.UserMapper;
import cn.arvin.pojo.User;
import cn.arvin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return userMapper.selectByPrimaryKey(id);
    }
}
