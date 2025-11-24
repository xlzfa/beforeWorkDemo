package com.xlzfa.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 用户表(User)实体类
 *
 * @author makejava
 * @since 2025-11-24 19:44:29
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -88887495276714028L;
/**
     * 用户ID
     */
    private Long id;
/**
     * 用户名
     */
    private String username;
/**
     * 密码
     */
    private String password;
/**
     * 邮箱
     */
    private String email;
/**
     * 创建时间
     */
    private Date createTime;
/**
     * 更新时间
     */
    private Date updateTime;


}

