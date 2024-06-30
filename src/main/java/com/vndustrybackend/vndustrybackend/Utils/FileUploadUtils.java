package com.vndustrybackend.vndustrybackend.Utils;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.vndustrybackend.vndustrybackend.Vars.*;

import org.springframework.web.multipart.MaxUploadSizeExceededException;

public class FileUploadUtils {
    public static File handleUpload(String filename, MultipartFile file) throws IOException, MaxUploadSizeExceededException {
        if (file == null || file.isEmpty()) {
            System.out.println("Error: Empty file");
            return null;
        }
        File fileTemp =  cache.child(filename).file();
        try (OutputStream stream = new FileOutputStream(fileTemp)) {
            stream.write(file.getBytes());
        }
        return fileTemp;
    }
}