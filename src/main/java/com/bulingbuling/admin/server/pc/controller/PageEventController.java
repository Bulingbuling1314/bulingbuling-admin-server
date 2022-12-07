package com.bulingbuling.admin.server.pc.controller;

import com.bulingbuling.admin.server.common.ResultMap;
import com.bulingbuling.admin.server.pc.entity.EventEntity;
import com.bulingbuling.admin.server.pc.entity.PageEntity;
import com.bulingbuling.admin.server.pc.entity.TracksEntity;
import com.bulingbuling.admin.server.pc.service.PageEventService;
import com.bulingbuling.admin.server.pc.vo.PageEventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;

@RestController
@RequestMapping(value = "/api/blog/pageEvent")
public class PageEventController {
    @Autowired
    private PageEventService pageEventService;

    @RequestMapping(value = "/add")
    public ResultMap add(@RequestBody PageEventEntity data) {
        System.out.print(data);
        if(data.getType() == 1) {
            PageEntity page = new PageEntity(data.getId(), data.getPageName(), data.getPagePath(), data.getDate());
            pageEventService.addPage(page);
        }
        if(data.getType() == 2) {
            EventEntity event = new EventEntity(data.getId(), data.getEventName(), data.getDate());
            pageEventService.addEvent(event);
        }
        if(data.getType() == 3) {
            TracksEntity tracks = new TracksEntity(data.getId(), data.getFromPath(), data.getToPath(), data.getDate(), data.getTracks());
            pageEventService.addTrack(tracks);
        }
        return new ResultMap().ok(data);
    }
}
