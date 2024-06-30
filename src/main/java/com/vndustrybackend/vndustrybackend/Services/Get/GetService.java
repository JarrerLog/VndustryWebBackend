package com.vndustrybackend.vndustrybackend.Services.Get;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vndustrybackend.vndustrybackend.Model.MapModel;
import com.vndustrybackend.vndustrybackend.Model.SchematicModel;

import arc.files.Fi;
import arc.struct.Seq;

import static com.vndustrybackend.vndustrybackend.Vars.*;

import java.io.IOException;
import java.util.HashMap;

public class GetService {

    public static MapModel getMap(String id) {
        for (Fi fi : getMaps()) {
            if (fi.nameWithoutExtension().equals(id)) {
                HashMap<Object, Object> data = readJson(fi);
                return new MapModel(data.get("name").toString(), data.get("desc").toString(), (int) data.get("height"),
                        (int) data.get("width"), (byte[]) data.get("image"), data.get("id").toString());
            }
        }
        return null;
    }

    public static SchematicModel getSchematic(String id) {
        for (Fi fi : getSchematics()) {
            if (fi.nameWithoutExtension().equals(id)) {
                HashMap<Object, Object> data = readJson(fi);
                return new SchematicModel(data);
            }
        }
        return null;
    }

    private static Seq<Fi> getMaps() {
        return mapSave.findAll();
    }

    private static Seq<Fi> getSchematics() {
        return schematicSave.findAll();
    }

    public static HashMap<Object, Object> readJson(Fi file) {
        try {
            return new ObjectMapper().readValue(file.reader(), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }
}
