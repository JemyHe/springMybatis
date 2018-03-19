package com.test.spring.service;

import com.test.spring.aspect.annotation.CountTime;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Service;

/**
 * Created by 何冠雄 on 2018/2/10.
 * 利用aop，测试每个方法运行时间
 * 通知类:CountTimeAspect
 *  ----通知类型：@Around 环绕通知 @Before 前置通知 @After 后置通知
 *              @AfterReturnning 方法正常结束后通知   @AfterThrowing 方法出现异常时通知
 * 切面：切点+业务类（目标类）
 * 切点:CountTimeAspect中@Around
 * 业务类:TestService
 */
@Service
public class TestService {

    @CountTime
    public void save(){
        System.out.println("========save========");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("========save========");
    }

    public void update(){
        System.out.println("========update========");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("========update========");
    }
}
