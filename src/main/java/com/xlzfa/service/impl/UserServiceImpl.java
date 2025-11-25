package com.xlzfa.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlzfa.domain.entity.User;
import com.xlzfa.domain.vo.UserVo;
import com.xlzfa.service.UserService;
import com.xlzfa.common.ResponseResult;
import com.xlzfa.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    public ResponseResult getById(Long id) {
        User user = baseMapper.selectById(id);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        System.out.println(userVo);
        return ResponseResult.success(userVo);
    }

}
