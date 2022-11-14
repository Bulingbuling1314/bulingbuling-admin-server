package com.bulingbuling.admin.server.pc.client;


import com.bulingbuling.admin.server.common.ResultMap;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 百度录用
@FeignClient(name="baidu-zhanzhang", url="http://data.zz.baidu.com/urls?site=www.blog.liubingbing.xyz&token=1Zy5boznKKpZmVua")
@Headers({"Host: data.zz.baidu.com", "User-Agent: curl/7.12.1", "Content-Type: text/plain"})
public interface BaiduClient {
    @RequestMapping(
            method = RequestMethod.POST
    )
    ResultMap baidu();
}