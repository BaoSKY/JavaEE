package com.Aspect;

import com.util.TransactionUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;

@Aspect
public class ServiceAspect {

    @Autowired(required = false)
    private TransactionUtil transactionUtil;

    @Pointcut("execution(* com.service*.*(..))")
    public void addTransaction(){

    }

    //异常通知：给添加事务的方法回滚事务，当方法抛出异常时
    @AfterThrowing("addTransaction()")
    public void rollbackTransaction(){
        //获取当前事务，然后回滚
        transactionUtil.rollback();
    }

    //环绕通知：给需要添加事务的方法，手动开启事务和提交事务
    @Around("addTransaction()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable{
        transactionUtil.begin();
        joinPoint.proceed();
        transactionUtil.commit();
    }
}
