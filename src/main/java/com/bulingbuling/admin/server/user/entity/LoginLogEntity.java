package com.bulingbuling.admin.server.user.entity;
import cn.hutool.core.date.DateTime;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="login_log")
@Getter
@Setter
public class LoginLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    /**
     * ip地址
     * @Type String
     * */
    @Column(name = "ip_path")
    private String ipPath;

    /**
     * 用户名
     * @Type String
     * */
    @Column(name = "user_name")
    private String userName;
    /**
     * 登陆时间
     * @Type String
     * */
    @Column(name = "login_date")
    private Date loginDate;

    public LoginLogEntity() {}

    public LoginLogEntity(String ip, String userName, Date date) {
        this.ipPath = ip;
        this.userName = userName;
        this.loginDate = date;
    }
}
