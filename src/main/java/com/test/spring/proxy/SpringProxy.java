package com.test.spring.proxy;

import com.test.spring.service.JDKProxyImpl;
import com.test.spring.service.TestService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by 何冠雄 on 2018/2/11.
 * 模拟spring代理生成
 * 用BeanPostProcessor将代理生成逻辑加到创建bean前后
 * 以为JDKProxy生成代理为例
 */
@Component
public class SpringProxy implements BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {

        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        //实现类代理类替换原来的目标service类
        if(o.getClass().equals(JDKProxyImpl.class)){
            final JDKProxyImpl target = (JDKProxyImpl) o;
            JDKProxy proxy = (JDKProxy) Proxy.newProxyInstance(SpringProxy.class.getClassLoader(), new Class[]{JDKProxy.class},
                    new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                            System.out.println("进入代理方法");
                            return method.invoke(target,args);
                        }
                    });
            return proxy;
        }
        return o;


    }
}
