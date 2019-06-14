package com.github.wz2cool.mdqvsother.jpa.test;

import com.github.wz2cool.mdqvsother.jpa.dao.UserDAO;
import com.github.wz2cool.mdqvsother.jpa.model.entity.UserDO;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDOTest {
    @Resource
    private UserDAO userDao;

    @Resource
    private Gson gson;

    @Before
    public void before() {
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setName("风清扬");
        userDO.setAccount("fengqy");
        userDO.setPwd("123456");
        userDao.save(userDO);
        userDO = new UserDO();
        userDO.setId(3L);
        userDO.setName("东方不败");
        userDO.setAccount("bubai");
        userDO.setPwd("123456");
        userDao.save(userDO);
        userDO.setId(5L);
        userDO.setName("向问天");
        userDO.setAccount("wentian");
        userDO.setPwd("123456");
        userDao.save(userDO);
    }

    @Test
    public void testAdd() {
        UserDO userDO = new UserDO();
        userDO.setId(2L);
        userDO.setName("任我行");
        userDO.setAccount("renwox");
        userDO.setPwd("123456");
        userDao.save(userDO);
        userDO = new UserDO();
        userDO.setId(4L);
        userDO.setName("令狐冲");
        userDO.setAccount("linghuc");
        userDO.setPwd("123456");
        userDao.save(userDO);

        List<UserDO> userDOList = userDao.findAll();
        System.out.println(String.format("所有结果：%s", gson.toJson(userDOList)));

        UserDO searchDO = new UserDO();
        searchDO.setId(2L);
        Example<UserDO> example = Example.of(searchDO);
        userDOList = userDao.findAll(example);
        System.out.println(String.format("查询id 为2的结果：%s", gson.toJson(userDOList)));
    }

    @After
    public void after() {
        userDao.delete(1L);
        userDao.delete(3L);
        userDao.delete(5L);
    }
}
