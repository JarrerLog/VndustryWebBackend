package com.vndustrybackend.vndustrybackend.Model;

import java.util.Base64;
import java.util.HashMap;

public class SchematicModel {
    private String name;
    private String desc;
    private int height;
    private int width;
    private double powerCon;
    private double powerProduction;
    private HashMap<Object, Object> requirements;
    private byte[] image;
    private String id;

    public SchematicModel(String name, String desc, int height, int width, double powerCon, double powerProduction, HashMap<Object, Object> requirements, byte[] image, String id) {
        this.name = name;
        this.desc = desc;
        this.height = height;
        this.width = width;
        this.powerCon = powerCon;
        this.powerProduction = powerProduction;
        this.requirements = requirements;
        this.image = image;
        this.id = id;

    }

    public SchematicModel(HashMap<Object, Object> data) {
        this.name = data.get("name").toString();
        this.desc = data.get("desc").toString();
        this.height = (int) data.get("height");
        this.width = (int) data.get("width");
        this.powerCon = (double) data.get("powerCon");
        this.powerProduction = (double) data.get("powerProduction");
        this.requirements = (HashMap<Object, Object>) data.get("requirements");
        this.image = Base64.getDecoder().decode(data.get("image").toString());
        this.id = data.get("id").toString();
    }

    public HashMap<Object, Object> toHashMap() {
        return new HashMap<Object, Object>() {
            {
                put("name", name);
                put("desc", desc);
                put("height", height);
                put("width", width);
                put("powerCon", powerCon);
                put("powerProduction", powerProduction);
                put("requirements", requirements);
                put("image", image);
                put("id", id);
            }
        };
    }

    public SchematicModel() {}

    public void setId(String id) {
        this.id = id;
    }
    public void setImage(byte[] image) {
        this.image = image;
    }
    public String getId() {
        return id;
    }
    public byte[] getImage() {
        return image;
    }

    public String getDesc() {
        return desc;
    }
    public int getHeight() {
        return height;
    }
    public String getName() {
        return name;
    }
    public double getPowerCon() {
        return powerCon;
    }
    public double getPowerProduction() {
        return powerProduction;
    }
    public HashMap<Object, Object> getRequirements() {
        return requirements;
    }
    public int getWidth() {
        return width;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPowerCon(double powerCon) {
        this.powerCon = powerCon;
    }
    public void setPowerProduction(double powerProduction) {
        this.powerProduction = powerProduction;
    }
    public void setRequirements(HashMap<Object, Object> requirements) {
        this.requirements = requirements;
    }
    public void setWidth(int width) {
        this.width = width;
    }


    
    
}

