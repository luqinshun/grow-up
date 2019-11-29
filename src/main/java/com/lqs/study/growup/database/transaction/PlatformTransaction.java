package com.lqs.study.growup.database.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @program: grow-up
 * @description: 手动创建事务
 * @author:luqinshun
 * @create: 2019-11-15 16:57
 **/
@Slf4j
public class PlatformTransaction {

    /**
     * 手动开启事务
     */
    public void start(DataSourceTransactionManager transactionManager){
        // 传播级别的定义
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        // 设置传播级别
        transactionDefinition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
        try {
            execute();
            transactionManager.commit(status);
        } catch (TransactionException e) {
            log.error("事务回滚");
            transactionManager.rollback(status);
            throw e;
        }
    }

    public void execute(){
        //
    }
}
