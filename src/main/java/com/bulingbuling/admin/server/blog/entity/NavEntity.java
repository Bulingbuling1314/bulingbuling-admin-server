package com.bulingbuling.admin.server.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="blog_nav_bar")
@Getter
@Setter
public class NavEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="delete_flag")
    private int deleteFlag;

    private String list;
}
