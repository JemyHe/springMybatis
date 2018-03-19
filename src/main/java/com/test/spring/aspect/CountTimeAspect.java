package com.test.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by 何冠雄 on 2018/2/10.
 */

@Aspect
@Component
public class CountTimeAspect {
    /**
     * 通知方法
     * @param pjp 调用其他通知或者目标
     * @return
     */
    /*@Around("within(com.test.spring.service.TestService)")*/
    /*@Around("execution(public void com.test.spring.service.TestService.save())")*/
    @Around("@annotation(com.test.spring.aspect.annotation.CountTime)")
    /**
     * 切点表达式:
     * within(包名.类名) ---- 匹配到类中所有方法
     * execution(修饰符 返回值 包名.类名.方法名(参数)) -----某一个或某些方法
     *  *:通配符;
     *  特例：用在方法参数上时，一个*号只代表一个任意参数
     *       ..用在方法参数上时，表示任何个数或类型的参数
     *  @annotation(注解)
     */
    public Object test(ProceedingJoinPoint pjp){
        long start = System.currentTimeMillis();
        try {
            //
            pjp.getTarget();//目标对象
            pjp.getSignature();//方法签名
            pjp.getArgs();//方法参数
            //return pjp.proceed(new Object[5,6]);//替换目标方法的参数
            //Object r = pjp.proceed(new Object[5,6]);//r为目标方法的返回值
            //return 2;//替换目标方法的返回值
            return pjp.proceed();//调用下一个通知或者目标
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        } finally {
            long end = System.currentTimeMillis();
            System.out.println("花费时间："+(end-start));
        }
    }

}
