package com.xlzfa.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
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
