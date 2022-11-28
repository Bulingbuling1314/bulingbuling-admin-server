package com.bulingbuling.admin.server.pc.controller;

import com.bulingbuling.admin.server.admin.blog.service.NavService;
import com.bulingbuling.admin.server.common.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping(value = "/api/blog/weex")
public class Picture {

    private ResultMap resultMap;

    @RequestMapping("/upload")
    public ResultMap UploadPicture(@RequestParam("file") MultipartFile file) throws IOException {
        if(file.isEmpty()){
            // 这里是我自定义的异常，可省略
            throw new IOException();
        }
        // 上传文件/图像到指定文件夹（这里可以改成你想存放地址的相对路径）
        File savePos = new File("src/main/resources/static/images/imgWall");
        if(!savePos.exists()){  // 不存在，则创建该文件夹
            savePos.mkdir();
        }
        // 上传该文件/图像至该文件夹下
        file.transferTo(new File("/home/upload/"+file.getOriginalFilename()));
        return resultMap.ok("http://www.liubingbing.xyz:8011/upload/" + file.getOriginalFilename());
    }
}
