package com.vndustrybackend.vndustrybackend;

import arc.files.Fi;
import arc.struct.ObjectMap;
import mindustry.type.Item;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Vars {
    public static final Fi dataDirectory = Fi.get(".community");
    public static final Fi cache = dataDirectory.child("cache");
    public static final Fi resources = dataDirectory.child("resources");
    public static final Fi sprites = dataDirectory.child("sprites");
    public static final Fi data = dataDirectory.child("data");
    public static final Fi schematicSave = data.child("schematics");
    public static final Fi mapSave = data.child("maps");


    public static final ObjectMap<String, BufferedImage> regions = new ObjectMap<>();
    public static final ObjectMap<Item, Long> emojis = new ObjectMap<>();

    public static BufferedImage currentImage;
    public static Graphics2D currentGraphics;

}
