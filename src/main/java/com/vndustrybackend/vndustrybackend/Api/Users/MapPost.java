package com.vndustrybackend.vndustrybackend.Api.Users;

import com.vndustrybackend.vndustrybackend.Handlers.MindustryHandler.ContentHandler;
import com.vndustrybackend.vndustrybackend.Utils.ErrorResponse;
import com.vndustrybackend.vndustrybackend.Utils.FileUploadUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Map;
import java.util.Objects;

@RestController
public class MapPost {
    @PostMapping("/api/v1/post/map")
    public ResponseEntity<Map<String, Object>> mapParser(@RequestParam("file") MultipartFile file) {
        try {
            if (file.getSize() > 10485760) {
                return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body(new ErrorResponse( "File size exceeds limit", 413).getErrObjects());
            }
            File savedFile = FileUploadUtils.handleUpload(Objects.requireNonNull(file.getOriginalFilename()), file);
            byte[] image = ContentHandler.parseMapImage(ContentHandler.parseMap(savedFile));
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("image", image));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse( "Invaild file post", 400).getErrObjects());
        }

    }

}
