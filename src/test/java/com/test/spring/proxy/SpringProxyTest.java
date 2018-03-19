package com.test.spring.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.test.spring.proxy.JDKProxy;


/**
 * Created by 何冠雄 on 2018/2/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpringProxyTest {

    @Autowired
    private JDKProxy jdkProxy;

    @Test
    public void postProcessBeforeInitialization() throws Exception {

    }

    @Test
    public void postProcessAfterInitialization() throws Exception {
        System.out.println(jdkProxy.getClass());
        jdkProxy.save();
    }

}