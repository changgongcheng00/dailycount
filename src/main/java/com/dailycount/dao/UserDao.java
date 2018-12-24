package com.dailycount.dao;

import com.dailycount.entity.User;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    int login(User user);

    List<User> findList(User user);

    Page<User> findList();

    User findById(int id);

    int deleteById(int id);

    int insert(User user);

    int updateById(User user);


}