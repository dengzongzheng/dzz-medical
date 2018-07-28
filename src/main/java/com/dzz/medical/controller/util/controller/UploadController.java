package com.dzz.medical.controller.util.controller;

import com.alibaba.fastjson.JSONObject;
import com.dzz.medical.common.response.ResponseDzz;
import com.dzz.medical.config.wx.UtilConfig;
import com.dzz.medical.controller.util.common.url.UtilUrlConstants;
import com.dzz.medical.controller.util.service.IdService;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传下载Controller
 *
 * @author dzz
 * @version 1.0.0
 * @since 2018年07月26 下午11:07
 */
@Controller
@Slf4j
public class UploadController {

    @Autowired
    private UtilConfig utilConfig;

    @Autowired
    private IdService idService;

    /**
     * 文件上传
     *
     * @param files   files
     * @param request request
     */
    @RequestMapping(value = UtilUrlConstants.FILE_UPLOAD, method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
    public void uploadFile(@RequestParam MultipartFile[] files, HttpServletRequest request,HttpServletResponse response) {

        String fileName = "";
        String originalFileName = "";
        Map<String, String> map = new HashMap<>(16);
        map.put("code", "1");
        map.put("message", "success");
        String uploadType = request.getParameter("uploadType");
        for (MultipartFile file : files) {
            try {
                if (!file.isEmpty()) {
                    originalFileName = file.getOriginalFilename();
                    String fileType = originalFileName.substring(originalFileName.indexOf("."));
                    fileName = String.valueOf(idService.getId())+fileType;
                    File file1 = new File(utilConfig.getUploadFilePath() + fileName);
                    file.transferTo(file1);
                    originalFileName = file.getOriginalFilename();
                }
            } catch (Exception e) {
                map.put("code", "0");
                map.put("message", "文件上传失败");
                log.error("文件上传失败!", e);
            }
        }
        map.put("originalFileName", originalFileName);
        map.put("fileName", fileName);

        ResponseDzz responseDzz = ResponseDzz.ok(map);
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().write(JSONObject.toJSONString(responseDzz));
        } catch (IOException e) {
            log.error("文件上传写出结果异常",e);
        }
    }

    /**
     * 获取图片
     *
     * @param response  response
     * @param imageName imageName
     */
    @RequestMapping(value = UtilUrlConstants.FILE_PIC_DOWN, method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity downPic(HttpServletResponse response, @RequestParam("imageName") String imageName)
            throws IOException {
        if (StringUtils.isBlank(imageName)) {
            return ResponseEntity.noContent().build();
        }
        String imageType = imageName.substring(imageName.indexOf(".") + 1);
        response.setContentType("image/" + imageType);
        try {
            String path = utilConfig.getUploadFilePath() + imageName;
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);
        } catch (Exception ex) {
            log.error("获取图片失败!", ex);
        }
        return ResponseEntity.noContent().build();
    }


}
