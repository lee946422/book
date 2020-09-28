package cn.lei.book.service.impl;

import cn.lei.book.dao.UserDao;
import cn.lei.book.pojo.User;
import cn.lei.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author lei
 * @Date 2020/9/18 16:07
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByName(String userName) {
       return userDao.selectByUserName(userName);
    }
}
