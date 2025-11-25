package com.xlzfa.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.xlzfa.common.ResponseResult;
import com.xlzfa.domain.entity.User;

public interface UserService extends IService<User> {

    public ResponseResult getById(Long id);

}
