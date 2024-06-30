package com.vndustrybackend.vndustrybackend.Api.Get;

import org.springframework.web.bind.annotation.RestController;

import com.vndustrybackend.vndustrybackend.Services.Get.GetService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api/v1/get")
public class GetSchematic {
    @GetMapping("/schematic/{id}")
    public HashMap<Object, Object> getMethodName(@PathVariable("id") String id) {
        try{
            return GetService.getSchematic(id).toHashMap();


        } catch (Exception e) {
            e.printStackTrace();
            return new HashMap<Object, Object>() {
                {
                    put("status", "Schematic not found");
                    put("id", id);
                }
            };
        }

    }
    
}
