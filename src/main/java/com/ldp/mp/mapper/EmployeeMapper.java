package com.ldp.mp.mapper;

import com.ldp.mp.beans.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liudongping
 * @since 2019-06-01
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    //定义的全局删除操作

    int deleteAll();
}
