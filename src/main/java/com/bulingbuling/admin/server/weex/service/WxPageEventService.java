package com.bulingbuling.admin.server.weex.service;

import com.bulingbuling.admin.server.common.ResultMap;
import com.bulingbuling.admin.server.pc.dao.EventDo;
import com.bulingbuling.admin.server.pc.dao.PageDo;
import com.bulingbuling.admin.server.pc.dao.TracksDo;
import com.bulingbuling.admin.server.weex.entity.EchartsEntity;
import com.bulingbuling.admin.server.weex.entity.WxPageEventEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WxPageEventService {
    @Autowired
    private PageDo pageDo;
    @Autowired
    private EventDo eventDo;
    @Autowired
    private TracksDo tracksDo;

    WxPageEventEntity result = new WxPageEventEntity();

    List<EchartsEntity> pageChartList = new ArrayList<>();
    List<EchartsEntity> eventChartList = new ArrayList<>();
    List<EchartsEntity> tracksChartList = new ArrayList<>();


    public ResultMap get() {
        result = new WxPageEventEntity();
        pageChartList = new ArrayList<>();
        eventChartList = new ArrayList<>();
        tracksChartList = new ArrayList<>();

        List<String> pageList = pageDo.findAllPageName();
        List<String> eventList = eventDo.findAllEventName();
        List<String> tracksList = tracksDo.findAllFromPath();

        for(String l: pageList) {
            EchartsEntity pageEchart = new EchartsEntity();
            pageEchart.setName(l);
            pageEchart.setValue(pageDo.findCountByPageName(l));
            pageChartList.add(pageEchart);
        }
        for(String e: eventList) {
            EchartsEntity eventEchart = new EchartsEntity();
            eventEchart.setName(e);
            eventEchart.setValue(eventDo.findCountByEventName(e));
            eventChartList.add(eventEchart);
        }
        for(String t: tracksList) {
            EchartsEntity tracksEchart = new EchartsEntity();
            tracksEchart.setName(t);
            if(null == tracksDo.findTracksByFromPath(t)) {
                tracksEchart.setValue(0);
            } else {
                tracksEchart.setValue(tracksDo.findTracksByFromPath(t));
            }
            tracksChartList.add(tracksEchart);
        }
        result.setPageData(pageChartList);
        result.setEventData(eventChartList);
        result.setTracksData(tracksChartList);

        return new ResultMap().ok(result);
    }
}
