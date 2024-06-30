package com.vndustrybackend.vndustrybackend.Model;

import java.util.HashMap;

public class MapModel {
    private String name;
    private String desc;
    private int height;
    private int width;
    private byte[] image;
    private String id;

    public MapModel(String name, String desc, int height, int width, byte[] image, String id) {
        this.name = name;
        this.desc = desc;
        this.height = height;
        this.width = width;
        this.image = image;
        this.id = id;
    }

    public HashMap<Object, Object> toHashMap() {
        return new HashMap<Object, Object>() {
            {
                put("name", name);
                put("desc", desc);
                put("height", height);
                put("width", width);
                put("image", image);
                put("id", id);
            }
        };
    }

    public MapModel() {}

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public String getDesc() {
        return desc;
    }
    public int getHeight() {
        return height;
    }
    public String getId() {
        return id;
    }
    public byte[] getImage() {
        return image;
    }
    public String getName() {
        return name;
    }
    public int getWidth() {
        return width;
    }
}
