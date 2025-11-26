package com.xlzfa.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xlzfa.config.JwtProperties;
import com.xlzfa.domain.dto.UserDto;
import com.xlzfa.domain.entity.User;
import com.xlzfa.domain.vo.UserVo;
import com.xlzfa.service.UserService;
import com.xlzfa.common.ResponseResult;
import com.xlzfa.mapper.UserMapper;
import com.xlzfa.util.BaseContext;
import com.xlzfa.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {


    @Autowired
    private JwtProperties jwtProperties;


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
        //没找到，返回
        if (user == null) {
            return ResponseResult.error("无此用户或者密码错误");
        }
        //装载荷
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        //生成token
        String token = JwtUtil.createJWT(
                jwtProperties.getSecretKey(),
                jwtProperties.getTtl(),
                claims);
        //装配VO
        UserVo userVo = UserVo.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .token(token)
                .build();

        return ResponseResult.success(userVo);
    }

    @Override
    public ResponseResult getMyInfo() {

        Long id = BaseContext.getCurrentId();
        User user = baseMapper.selectById(id);
        UserVo userVo = UserVo.builder()
                .username(user.getUsername())
                .createTime(user.getCreateTime())
                .email(user.getEmail())
                .build();

        return ResponseResult.success(userVo);
    }

}
