package com.test.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by 何冠雄 on 2018/2/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Test
    public void pay() throws Exception {
        int orderId = 10;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,99);
        map.put(2,99);
        map.put(3,99);
        orderService.pay(orderId,map);
    }

}