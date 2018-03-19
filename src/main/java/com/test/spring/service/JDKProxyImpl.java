package com.test.spring.service;

import com.test.spring.proxy.JDKProxy;
import org.springframework.stereotype.Service;

/**
 * Created by 何冠雄 on 2018/2/11.
 */
@Service
public class JDKProxyImpl implements JDKProxy {

    public void save(){
        System.out.println("目标的save()");
    }

    public void update(){
        System.out.println("目标的update()");
    }
}
