package com.bulingbuling.admin.server.pc.controller;

import com.bulingbuling.admin.server.common.ResultMap;
import com.bulingbuling.admin.server.pc.service.BaiduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/blog/baidu")
public class BaiduController {

    @Autowired
    BaiduService baiduService;
    @RequestMapping(value = "/recruit")
    public ResultMap recruit(@RequestParam String url) {
        return baiduService.recruit(url);
    }
}
