package com.bulingbuling.admin.server.pc.entity;

import com.bulingbuling.admin.server.pc.vo.PageEventEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="page_logging")
@Getter
@Setter
public class PageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "page_name")
    private String pageName;

    @Column(name = "page_path")
    private String pagePath;

    @Column(name = "date")
    private String date;

    public PageEntity(int id, String pageName, String pagePath, String date) {
        this.id = id;
        this.pageName = pageName;
        this.pagePath = pagePath;
        this.date = date;
    }

    public PageEntity() {

    }
}
