package com.bulingbuling.admin.server.pc.vo;

import lombok.Data;


@Data
public class PageEventEntity {
    private int id;
    private int type;
    private String pageName;
    private String pagePath;
    private String date;
    private String eventName;
    private String fromPath;
    private String toPath;
    private long tracks;
}
