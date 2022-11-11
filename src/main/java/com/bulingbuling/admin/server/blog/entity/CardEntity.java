package com.bulingbuling.admin.server.blog.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="blog_card_bar")
@Getter
@Setter
public class CardEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="url")
    private String url;

    @Column(name="card_id")
    private int cardId;

    @Column(name="delete_flag")
    private int deleteFlag;
}
