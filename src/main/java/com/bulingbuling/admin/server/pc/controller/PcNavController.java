package com.bulingbuling.admin.server.pc.controller;

import com.bulingbuling.admin.server.admin.blog.service.NavService;
import com.bulingbuling.admin.server.common.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/blog/nav")
public class PcNavController {

    @Autowired
    private NavService navService;

    @RequestMapping(value = "/getAll")
    public ResultMap getAll() {
        return navService.findAll();
    }
}
