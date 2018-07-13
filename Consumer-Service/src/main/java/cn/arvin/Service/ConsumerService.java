package cn.arvin.Service;

import cn.arvin.Dao.ConsumerDao;
import cn.arvin.Pojo.User;
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

    @Autowired
    private ConsumerDao consumerDao;

    public List<User> queryUserById(List<Long> ids){

        ArrayList<User> users = new ArrayList<>();

        //lambda遍历数组获取用户并添加到集合中
        ids.forEach(id ->users.add(consumerDao.queryUserById(id)));

        return users;
    }
}
