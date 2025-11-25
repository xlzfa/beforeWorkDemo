package com.xlzfa.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlzfa.domain.dto.UserDto;
import com.xlzfa.domain.entity.User;
import com.xlzfa.domain.vo.UserVo;
import com.xlzfa.service.UserService;
import com.xlzfa.common.ResponseResult;
import com.xlzfa.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public ResponseResult getById(Long id) {
        User user = baseMapper.selectById(id);
        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user, userVo);
        System.out.println(userVo);
        return ResponseResult.success(userVo);
    }

    @Override
    public ResponseResult login(UserDto userDto) {

        //获取提交的用户名和密码
        String username = userDto.getUsername();
        String password = userDto.getPassword();
        //装配sql
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username)
                .eq("password", password);

        User user = baseMapper.selectOne(wrapper);
        if (user == null) {
            return ResponseResult.error("无此用户或者密码错误");
        }

        return ResponseResult.success();
    }

}
