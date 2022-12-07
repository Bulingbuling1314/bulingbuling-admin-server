package com.bulingbuling.admin.server.weex.entity;

import lombok.Data;

import java.util.List;

@Data
public class WxPageEventEntity {
    private List<EchartsEntity> pageData;
    private List<EchartsEntity> eventData;
    private List<EchartsEntity> tracksData;
}
