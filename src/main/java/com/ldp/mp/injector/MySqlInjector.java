package com.ldp.mp.injector;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**
 * @author Return
 * @create 2019-06-02 19:40
 */

//自定义全局 操作
    //不需要子啊配置文件中写SQL语句
    //1.首先在接口中定义方法  自定义注入全表删除方法 deteleAll
    //2.然后需要的自己定义一个类MySqlInjector继承AutoSqlInjector
    //3.重写inject方法
    //4.将自己创建的类注入到容器当中，并且在全局策略中注入

public class MySqlInjector extends AutoSqlInjector {
    @Override
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass, Class<?> modelClass, TableInfo table) {
        //将EmployeeMapper中定义的deleteAll， 处理成对应的MappedStatement对象，加入到configuration对象中。
        //注入的SQL语句
        String sql = "delete from " +table.getTableName();
        //注入的方法名   一定要与EmployeeMapper接口中的方法名一致
        String method = "deleteAll" ;

        //构造SqlSource对象
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);

        //构造一个删除的MappedStatement
        this.addDeleteMappedStatement(mapperClass, method, sqlSource);
    }
}
