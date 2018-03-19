package com.test.spring.proxy;

import org.springframework.stereotype.Component;

/**
 * Created by 何冠雄 on 2018/2/11.
 * spring实现代理的底层技术一：
 * jdk方式实现代理
 * 需要声明一个接口
 * 实现该接口的类才能生成代理
 */
public interface JDKProxy {

    void save();

    void update();
}
