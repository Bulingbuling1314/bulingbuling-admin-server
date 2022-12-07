package com.bulingbuling.admin.server.weex.controller;


import com.bulingbuling.admin.server.common.ResultMap;
import com.bulingbuling.admin.server.weex.service.WxPageEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/blog/weex")
public class WxPageEventController {

    private ResultMap resultMap;

    @Autowired
    private WxPageEventService wxPageEventService;

    @RequestMapping("/getBlogChart")
    public ResultMap getBlogChart() {
        return wxPageEventService.get();
    }
}
