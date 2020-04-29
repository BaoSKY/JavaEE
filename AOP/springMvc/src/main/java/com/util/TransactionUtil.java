package com.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
@Scope("prototype")//设置成原型状态，避免线程安全问题
public class TransactionUtil {

    private TransactionStatus transactionStatus = null;

    @Autowired
    private DataSourceTransactionManager transactionManager;


    public void begin(){
        System.out.println("方法上有事务注解，使用手动的方式开启事务...");
        transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
    }

    public void commit(){
        if(transactionStatus != null){
            System.out.println("提交事务...");
            transactionManager.commit(transactionStatus);
        }
    }

    public void rollback(){
        if(transactionStatus != null) {
            System.out.println("回滚事务...");
            transactionManager.rollback(transactionStatus);
        }
    }
}