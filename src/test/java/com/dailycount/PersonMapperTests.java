package com.dailycount;

/**
 * @ClassName PersonMapperTests
 * @Description TODO
 * @Author cheng
 * @Date 2018/12/25 1:15
 **/
import com.dailycount.configuration.PageInfo;
import com.dailycount.entity.User;
import com.dailycount.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonMapperTests {

    private Logger logger = LoggerFactory.getLogger(PersonMapperTests.class);

    @Autowired
    private UserService userService;

    @Before
    public void testInsert() {
        User user = new User();
        user.setRole("1");
        user.setPassword("2");
        user.setUsername("2");
        userService.insert(user);
        Assert.assertNotNull(user.getId());
        logger.debug(JSON.toJSONString(user));
    }

    @Test
    public void testFindAll() {
        User u = new User();
        u.setRole("1");
        List<User> user = userService.findList(u);
        Assert.assertNotNull(user);
        logger.debug(JSON.toJSONString(user));
    }

    @Test
    public void testFindByPage() {
        PageHelper.startPage(1,2);
        Page<User> persons = userService.findByPage();
        // 需要把Page包装成PageInfo对象才能序列化。该插件也默认实现了一个PageInfo
        PageInfo<User> pageInfo = new PageInfo<>(persons);
        Assert.assertNotNull(persons);
        logger.debug(pageInfo.toString());
        logger.debug(JSON.toJSONString(pageInfo));
    }

    @Test
    public void testCacheByPage() {
        long begin = System.currentTimeMillis();
        User u = new User();
        u.setRole("1");
        List<User> user = userService.findList(u);
        long ing = System.currentTimeMillis();
        userService.findList(u);
        long end = System.currentTimeMillis();
        logger.debug("第一次请求时间：" + (ing - begin) + "ms");
        logger.debug("第二次请求时间:" + (end - ing) + "ms");

        Assert.assertNotNull(user);
        logger.debug(user.toString());
        logger.debug(JSON.toJSONString(user));
    }

}

