package com.bulingbuling.admin.server.user.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="menu")
@Getter
@Setter
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * 路由名称
     * @Type String
     * */
    @Column(name = "name")
    private String name;

    /**
     * 路由地址
     * @Type String
     * */
    @Column(name = "path")
    private String path;

    /**
     * 路由组件名称
     * @Type String
     * */
    @Column(name = "component")
    private String component;

    /**
     * 路由其他信息
     * @Type String
     * */
    @Column(name = "meta")
    private String meta;

    /**
     * 路由类型 1：目录、2：菜单、3：按钮
     * @Type int
     * */
    @Column(name = "type")
    private int type;

    /**
     * 路由上级path
     * @Type String
     * */
    @Column(name = "parent_path")
    private String parentPath;

}
