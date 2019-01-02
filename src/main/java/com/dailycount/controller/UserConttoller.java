package com.dailycount.controller;

import com.alibaba.druid.wall.violation.ErrorCode;
import com.dailycount.configuration.PageInfo;
import com.dailycount.configuration.ResponseData;
import com.dailycount.entity.User;
import com.dailycount.repository.UserRepository;
import com.dailycount.service.UserService;
import com.github.pagehelper.PageHelper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserConttoller
 * @Description TODO
 * @Author cheng
 * @Date 2018/12/24 23:14
 **/
@Api(tags = "用户管理")
@RestController
@EnableAutoConfiguration
@RequestMapping("/users")
public class UserConttoller {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value="用户查询")
    @RequestMapping(value = "/list",method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PageInfo<User> findList(@RequestBody User user){
        //mybatis查询
//        userService.findList(user);
        //jpa查询
//        return userRepository.findAll();
        //mybatis分页查询
        PageHelper.startPage(1,2);
        PageInfo<User> pageInfo = new PageInfo<>(userService.findByPage());
        return pageInfo;
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseData login(@RequestBody User user){
        int result =userService.login(user);
        if(result >=1){
            return ResponseData.success();
        }else{
            return ResponseData.error(ErrorCode.SYNTAX_ERROR,"账号密码错误");
        }
    }
}
