package com.lqs.study.growup.database.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

/**
 * @program: grow-up
 * @description: 慢SQL日志查询
 * @author:luqinshun
 * @create: 2019-11-15 18:14
 **/
@Intercepts(
        @Signature(type= Executor.class,method = "query",args={MappedStatement.class,Object.class, RowBounds.class, ResultHandler.class})
)
public class SlowSqlInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        Object parameter = null;
        if(invocation.getArgs().length>1){
            parameter=invocation.getArgs()[1];
        }
        BoundSql boundSql = mappedStatement.getBoundSql(parameter);
        // 代占位符的sql
        String sql = boundSql.getSql();
        Configuration configuration = mappedStatement.getConfiguration();
        // 执行语句的操作
        Object proceed = invocation.proceed();
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target,this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
