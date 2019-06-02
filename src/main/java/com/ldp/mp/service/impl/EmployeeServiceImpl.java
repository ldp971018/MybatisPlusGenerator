package com.ldp.mp.service.impl;

import com.ldp.mp.beans.Employee;
import com.ldp.mp.mapper.EmployeeMapper;
import com.ldp.mp.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liudongping
 * @since 2019-06-01
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}
