package com.lyx.controller;

import com.lyx.model.TUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("file")
public class FileController {
    private Map<String , Object> resMap;

    @RequestMapping("fileUpload")
    @ResponseBody
    public Map<String , Object> fileUpload(HttpServletRequest request, @RequestParam("upload") CommonsMultipartFile upload ) throws Exception {
        resMap = new HashMap<>();
        System.out.println("springMVC方式文件上传中！");
        //使用fileupload组件上传文件
        //上传位置
        String path = request.getSession().getServletContext().getRealPath("/upload/");
        //判断该路径是否存在
        File file = new File(path);
        if(!file.exists()){
            //创建文件夹
            file.mkdirs();
        }
        //上传文件
        //获取文件名
        String filename = upload.getOriginalFilename();
        //通过uuid控制文件名唯一
        String uuid = UUID.randomUUID().toString().replace("-","");
        filename = uuid+"_"+filename;
        //文件上传
        upload.transferTo(new File(path,filename));
        System.out.println(path);
        resMap.put("result","success");
        resMap.put("photo","upload/"+filename);
        return resMap;
    }
}
