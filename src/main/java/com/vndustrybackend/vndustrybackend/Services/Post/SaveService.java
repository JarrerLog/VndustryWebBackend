package com.vndustrybackend.vndustrybackend.Services.Post;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.UUID;

import javax.xml.validation.Schema;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vndustrybackend.vndustrybackend.Model.MapModel;
import com.vndustrybackend.vndustrybackend.Model.SchematicModel;

import mindustry.game.Schematic;
import mindustry.maps.Map;

import static com.vndustrybackend.vndustrybackend.Vars.*;

public class SaveService {

    public Schematic schematic = null;
    public Map map = null;
    public byte[] image = null;
    public String id;

    public SaveService(Schematic schematic, byte[] image, String id) {
        this.image = image;
        this.schematic = schematic;
        this.id = id;
    }

    public SaveService(Map map, byte[] image, String id) {
        this.image = image;
        this.map = map;
        this.id = id;
    }

    public boolean save() {
        HashMap<Object, Object> data = new HashMap<>();
        if (schematic != null) {
            HashMap<Object, Object> requirements = new HashMap<>();
            data.put("name", schematic.name());
            data.put("desc", schematic.description());
            data.put("height", schematic.height);
            data.put("width", schematic.width);
            data.put("tiles", schematic.tiles.size);
            data.put("powerCon", schematic.powerConsumption());
            data.put("powerProduction", schematic.powerProduction());
            schematic.requirements().each((item, amount) -> {

                requirements.put(item.name, amount);
            });
            data.put("requirements", requirements);
            data.put("image",image);
            data.put("id", requirements);
            return save(schematicSave.file(), id + ".json", new SchematicModel(schematic.name(), schematic.description(), schematic.height, schematic.width, schematic.powerConsumption(), schematic.powerProduction(), requirements, image, id));
        }

        data.put("name", map.name());
        data.put("id", id);
        data.put("desc", map.description());
        data.put("image",image);
        data.put("height", map.height);
        data.put("width", map.width);
        return save(mapSave.file(), id + ".json", new MapModel(map.name(), map.description(), map.height, map.width, image, id));


    }

    private boolean save(File saveFile, String nameSave,SchematicModel data) {

        try {
            File save = new File(saveFile, nameSave);
            save.createNewFile();
            String jsonString = new ObjectMapper().writeValueAsString(data.toHashMap());
            Files.write(save.toPath(), jsonString.getBytes());
            return true;
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
    private boolean save(File saveFile, String nameSave,MapModel data) {

        try {
            File save = new File(saveFile, nameSave);
            save.createNewFile();
            String jsonString = new ObjectMapper().writeValueAsString(data.toHashMap());
            Files.write(save.toPath(), jsonString.getBytes());
            return true;
            
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
    
}


