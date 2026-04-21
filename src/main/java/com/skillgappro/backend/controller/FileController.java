package com.skillgappro.backend.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/api/files")

public class FileController {

    private final Cloudinary cloudinary;

    public FileController(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    // ✅ Upload file to Cloudinary
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            Map uploadResult = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.emptyMap()
            );

            // Return file URL
            return uploadResult.get("url").toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Upload failed!";
        }
    }
}
