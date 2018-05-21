package com.yh.swim.console.controller;

import com.alibaba.fastjson.JSONObject;
import com.yh.swim.common.web.Constants;
import com.yh.swim.service.product.UploadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 图片上传控制器
 *
 * @author 严欢
 */
@Controller
public class PicUploadController {

    @Resource
    private UploadService uploadService;

    /**
     * 上传图片
     */
    @RequestMapping(value = "/upload/uploadPic")
    public void uploadPic(@RequestParam(required = false) MultipartFile pic, HttpServletResponse response) throws IOException {
        String path = uploadService.uploadPic(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());
        String url = Constants.IMG_URL + path;
        JSONObject jo = new JSONObject();
        jo.put("url", url);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(jo.toString());
    }
}
