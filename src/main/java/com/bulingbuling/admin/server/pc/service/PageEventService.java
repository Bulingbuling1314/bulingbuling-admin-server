package com.bulingbuling.admin.server.pc.service;

import com.bulingbuling.admin.server.common.ResultMap;
import com.bulingbuling.admin.server.pc.dao.EventDo;
import com.bulingbuling.admin.server.pc.dao.PageDo;
import com.bulingbuling.admin.server.pc.dao.TracksDo;
import com.bulingbuling.admin.server.pc.entity.EventEntity;
import com.bulingbuling.admin.server.pc.entity.PageEntity;
import com.bulingbuling.admin.server.pc.entity.TracksEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PageEventService {
    ResultMap resultMap = new ResultMap();
    @Resource
    private PageDo pageDo;
    @Resource
    private EventDo eventDo;
    @Resource
    private TracksDo tracksDo;

    public ResultMap addPage(PageEntity page) {
        pageDo.save(page);
        return resultMap.ok("ok");
    }
    public ResultMap addEvent(EventEntity event) {
        eventDo.save(event);
        return resultMap.ok("ok");
    }
    public ResultMap addTrack(TracksEntity track) {
        tracksDo.save(track);
        return resultMap.ok("ok");
    }
}
