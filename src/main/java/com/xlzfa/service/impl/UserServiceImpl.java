package com.xlzfa.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlzfa.entity.User;
import com.xlzfa.service.UserService;
import com.xlzfa.common.ResponseResult;
import com.xlzfa.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    public ResponseResult getById(Long id) {
        User user = baseMapper.selectById(id);
        return ResponseResult.success(user);
    }

}
