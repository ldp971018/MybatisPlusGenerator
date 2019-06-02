package com.ldp.mp.service.impl;

import com.ldp.mp.beans.User;
import com.ldp.mp.mapper.UserMapper;
import com.ldp.mp.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liudongping
 * @since 2019-06-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
