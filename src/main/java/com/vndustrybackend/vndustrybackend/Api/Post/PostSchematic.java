package com.vndustrybackend.vndustrybackend.Api.Post;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vndustrybackend.vndustrybackend.Handlers.MindustryHandler.ContentHandler;
import com.vndustrybackend.vndustrybackend.Services.Post.SaveService;
import com.vndustrybackend.vndustrybackend.Utils.FileUploadUtils;

import mindustry.game.Schematic;
import mindustry.game.Schematics;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/post")
public class PostSchematic {

    @PostMapping("/schematic")
    public HashMap<Object, Object> postSchematic(@RequestParam("file") MultipartFile file) {
        String id = UUID.randomUUID().toString().replace("-", "");

        // TODO: process POST request
        try {
            File savedFile = FileUploadUtils.handleUpload(id + ".msav", file);

            if (handleSchematic(savedFile, id)) {
                return new HashMap<Object, Object>() {
                    {
                        put("status", "success");
                        put("id", id);

                    }
                };
            } else {
                return new HashMap<Object, Object>() {
                    {
                        put("status", "failed");
                        put("id", id);
                    }
                };
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<Object, Object>() {
                {
                    put("status", "failed");
                    put("id", id);
                }
            };
        }
    }

    private boolean handleSchematic(File file, String id) throws IOException {

        Schematic schematic = ContentHandler.parseSchematic(file);
        byte[] image = ContentHandler.parseSchematicImage(schematic);

        SaveService save = new SaveService(schematic, image, id);
        return save.save();
    }

}
