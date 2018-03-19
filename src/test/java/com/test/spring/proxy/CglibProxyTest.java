package com.test.spring.proxy;

import com.test.spring.service.JDKProxyImpl;
import com.test.spring.service.TestService;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Created by 何冠雄 on 2018/2/11.
 */
public class CglibProxyTest {

    /**
     * 用cglib模拟jdkproxy实现接口方式的代理生成模式
     */
    @Test
    public void testcglib(){
        final JDKProxyImpl target = new JDKProxyImpl();
        Enhancer enhancer = new Enhancer();
        enhancer.setInterfaces(new Class[]{JDKProxy.class});
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("进入代理对象。。。。");
                method.invoke(target,objects);//调用目标方法
                return null;
            }
        });
        JDKProxy jdkProxy = (JDKProxy) enhancer.create();
        System.out.println(jdkProxy.getClass());
        jdkProxy.save();
    }

    /**
     * 根据可继承的父类对象生成子类代理
     */
    @Test
    public void testcglib2(){
        final TestService target = new TestService();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestService.class);//设置父类对象
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("进入代理对象。。。。");
                method.invoke(target,objects);//调用目标方法
                return null;
            }
        });
        TestService proxy = (TestService) enhancer.create();
        System.out.println(proxy.getClass());
        proxy.save();

    }

}