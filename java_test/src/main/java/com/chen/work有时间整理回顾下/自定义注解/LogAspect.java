package com.chen.work有时间整理回顾下.自定义注解;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Around("@annotation(myLog)")
    public Object around(ProceedingJoinPoint point, MyLog myLog) throws Throwable{
        // 通过ProceedingJoinPoint获取方法名和方法所在的类名 反射
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        String value = myLog.value();
        log.info("类名：{}，方法名：{}，注解值：{}",className,methodName,value);
        log.info("方法之前执行");
        long startTime = System.currentTimeMillis();
        // 此方法的返回值
        // 在这行代码之前的代码会在方法之前执行，之后的会在方法执行完以后再执行
        Object proceed = point.proceed();
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        log.info("方法之后执行");
        log.info("方法耗时：{}", time);
        log.info(proceed.toString()); // sss
        return proceed;
    }

}
