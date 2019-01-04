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
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName UserConttoller
 * @Description TODO
 * @Author cheng
 * @Date 2018/12/24 23:14
 **/
@RestController
@EnableAutoConfiguration
public class BaseConttoller {

    @RequestMapping(value = "/toLogin")
    public ModelAndView main(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/index")
    public ModelAndView index(){
        return new ModelAndView("index");
    }
}
