package com.test.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by 何冠雄 on 2018/2/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class TestServiceTest {

    @Autowired
    private TestService testService;

    @Test
    public void save() throws Exception {
        testService.save();
    }

    @Test
    public void update() throws Exception {
        testService.update();
    }

}