package edu.hust.controller;

import edu.hust.pojo.Result;
import edu.hust.utils.AliOssUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @Autowired
    private AliOssUtils aliOssUtils;

    private Logger log = LoggerFactory.getLogger(UploadController.class);


    @PostMapping
    public Result upload(MultipartFile image) throws IOException {
        log.info("上传文件：{}", image.getOriginalFilename());
        //调用OSS工具类上传文件
        String url = aliOssUtils.upload(image);
        log.info("上传成功，url：{}", url);
        return Result.success(url);
    }
}
