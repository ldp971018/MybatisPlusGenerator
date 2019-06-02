package com.ldp.mp.test;

import com.baomidou.mybatisplus.plugins.Page;
import com.ldp.mp.beans.Employee;
import com.ldp.mp.beans.User;
import com.ldp.mp.mapper.EmployeeMapper;
import com.ldp.mp.mapper.UserMapper;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.commons.io.IOCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author Return
 * @create 2019-06-02 18:25
 */
public class pageTest {

    ApplicationContext ctx  = new ClassPathXmlApplicationContext("applicationContext.xml");

    EmployeeMapper employeeMapper = ctx.getBean("employeeMapper",EmployeeMapper.class);
    UserMapper userMapper=ctx.getBean("userMapper",UserMapper.class);


    /*分页插件的测试*/
    @Test
    public void testPage(){
        //定义分页信息
        Page<Employee> page=new Page<Employee>(1,5);
        //开始查询
        List<Employee> employees = employeeMapper.selectPage(page, null);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("================分页信息================");
        System.out.println("当前页码"+page.getCurrent());
        System.out.println("总页码数"+page.getPages());
        System.out.println("每页的记录数"+page.getSize());
        System.out.println("总记录数"+page.getTotal());
        System.out.println("是否有上一页"+page.hasPrevious());
        System.out.println("是否有下一页"+page.hasNext());
    }

    /*性能分析插件*/
    @Test
    public void testXingNeng(){
        Employee employee=new Employee("大野人","1846882398@q.com","0",20);
        employeeMapper.insert(employee);
        System.out.println("===>"+employee);
        /*Time：29 ms - ID：com.ldp.mp.mapper.EmployeeMapper.insert
         Execute SQL：
            INSERT
            INTO
                tbl_employee
                ( last_name, email, gender, age )
            VALUES
                ( '孟志扬', '1846882398@q.com', '0', 22 )]*/
    }

    /*乐观锁插件的测试LockerInterceptor
    *意图：
        当要更新一条记录的时候，希望这条记录没有被别人更新
     乐观锁实现方式：
        取出记录时，获取当前version
        更新时，带上这个version
        执行更新时， set version = yourVersion+1 where version = yourVersion
        如果version不对，就更新失败
      1）、需要在字段中添加version注解的属性，同时在数据库中也需要添加
    * */
    @Test
    public void testLockerInterceptor(){
        Employee employee=new Employee(8,"小野人","1846882398@qq.com","0",20,2);
        Integer integer = employeeMapper.updateById(employee);
    }

    /*测试自定义的全局删除*/
    @Test
    public void injector(){
        employeeMapper.deleteAll();
    }

    /*测试逻辑删除*/

    @Test
    public void testLoginc(){
        /*Integer result = userMapper.deleteById(1);
        System.out.println("result:"+result);*/
        User user = userMapper.selectById(1);
        System.out.println("user:"+user);
    }

}
