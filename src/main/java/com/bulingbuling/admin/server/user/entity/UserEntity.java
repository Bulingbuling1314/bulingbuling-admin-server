package com.bulingbuling.admin.server.user.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
@Getter
@Setter
public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    /**
     * ID
     * @Type int
     * */
    private int id;

    /**
     * 用户名
     * @Type String
     * */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     * @Type String
     * */
    @Column(name = "password")
    private String password;

    /**
     * 昵称
     * @Type String
     * */
    @Column(name = "nick_name")
    private String nickName;

    /**
     * 角色权限
     * @Type String
     * */
    @Column(name = "role")
    private String role;

    /**
     * 登录次数
     * @Type int
     * */
    @Column(name = "login_count")
    private int loginCount;
}
