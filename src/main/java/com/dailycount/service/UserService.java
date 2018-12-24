package com.dailycount.service;

import com.dailycount.entity.User;
import com.github.pagehelper.Page;

import java.util.List;

public interface UserService {
    int login(User user);

    List<User> findList(User user);

    Page<User> findByPage();

    User findById(int id);

    int deleteById(int id);

    int insert(User user);

    int updateById(User user);
}
