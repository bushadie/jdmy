package cn.bushadie.excel.controller;

import cn.bushadie.excel.ExcelUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * @author jdmy
 * on 2019/3/26.
 **/
@RestController
public class BaseController {
    @PostMapping("/upload")
    public String upload(HttpServletRequest request){
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile file = multipartRequest.getFile("fileUpload");
        try {
            ExcelUtils.poiXlsReader(file.getInputStream());
        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("upload");
        return "upload";
    }
}
