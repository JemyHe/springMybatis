package com.test.spring.service;

import com.test.spring.proxy.JDKProxy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

/**
 * Created by 何冠雄 on 2018/2/11.
 */
public class JDKProxyImplTest {


    @Test
    public void save() throws Exception {

        final JDKProxyImpl target = new JDKProxyImpl();

        ClassLoader loader = JDKProxyImplTest.class.getClassLoader();//类加载器，用来将生成的代理类加载到jvm
        Class[] interfaces = new Class[]{JDKProxy.class};//代理类需要实现的接口类型
        /*
            代理类中每个方法要执行的逻辑
         */
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("进入了代理类的方法");
                System.out.println("开始事务");
                try{
                    //target.update();//正常调用
                    method.invoke(target,args);//反射调用：方法.invoke(对象，参数);
                    System.out.println("提交事务");
                }catch (Exception e){
                    System.out.println("回滚事务");
                }
                return null;
            }
        };
        JDKProxy proxy = (JDKProxy)Proxy.newProxyInstance(loader, interfaces, handler);
        System.out.println(proxy.getClass());
        proxy.save();
    }

    @Test
    public void update() throws Exception {
    }

}