package com.test.spring.service;

import com.test.spring.mapper.OrderMapper;
import com.test.spring.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * Created by 何冠雄 on 2018/2/9.
 */
@Service
public class OrderService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Transactional(rollbackFor = Exception.class)
    public void pay(int orderId, Map<Integer,Integer> map){

        orderMapper.updateState(orderId);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            productMapper.updateStorage(entry.getKey(),entry.getValue());
        }
    }
}
