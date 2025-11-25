package com.xlzfa.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
//用户ID
    private Long id;
//用户名
    private String username;
//密码
    private String password;
//邮箱
    private String email;
//创建时间
    private Date createTime;
//更新时间
    private Date updateTime;
}

//    private static final long serialVersionUID = -88887495276714028L;
