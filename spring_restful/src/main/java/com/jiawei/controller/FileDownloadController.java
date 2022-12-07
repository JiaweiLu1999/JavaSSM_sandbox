package com.jiawei.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Controller
public class FileDownloadController {
    private static final String SUCCESS = "success";
    private static final String DOWNLOAD = "file_download";

    @RequestMapping("/toFileDownloadPage")
    public String toFileDownloadPage() {
        return DOWNLOAD;
    }


    @RequestMapping("/fileDownloadController")
    public ResponseEntity<byte[]> fileDownloadController(HttpServletRequest request, @RequestParam String filename) {
        String path = request.getServletContext().getRealPath("/WEB-INF/download/") + filename;
        ResponseEntity<byte[]> responseEntity;

        try {
            FileInputStream inputStream = new FileInputStream(path);
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Content-Disposition", "attachment;filename=" + filename);
            httpHeaders.setContentDispositionFormData("attachment",
                    new String(filename.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1));
            inputStream.close();

            responseEntity = new ResponseEntity<>(bytes, httpHeaders, HttpStatus.OK);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return responseEntity;
    }

    @RequestMapping("/fileUploadController")
    public String fileUploadController(MultipartFile file, HttpSession session) throws IOException {
        String filename = file.getOriginalFilename();
        String uploadPath = session.getServletContext().getRealPath("/WEB-INF/upload/");
        File filePath = new File(uploadPath);
        if(!filePath.exists()) {
            filePath.mkdir();
        }

        String uuid = UUID.randomUUID().toString().replace("-", "");
        File uploadFile = new File(uploadPath + uuid + "_" + filename);
        file.transferTo(uploadFile);

        return SUCCESS;
    }
}
