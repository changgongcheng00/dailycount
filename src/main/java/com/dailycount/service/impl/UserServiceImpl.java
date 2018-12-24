package com.dailycount.service.impl;

import com.dailycount.dao.UserDao;
import com.dailycount.entity.User;
import com.dailycount.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author cheng
 * @Date 2018/12/24 18:09
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int login(User user) {
        return userDao.login(user);
    }

    @Override
    public List<User> findList(User user) {
        return userDao.findList(user);
    }

    @Override
    public Page<User> findByPage() {
        return userDao.findList();
    }

    @Override
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    public int deleteById(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int updateById(User user) {
        return userDao.updateById(user);
    }
}
