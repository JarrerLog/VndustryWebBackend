package com.vndustrybackend.vndustrybackend.Api.Users;

import com.vndustrybackend.vndustrybackend.Handlers.MindustryHandler.ContentHandler;
import mindustry.game.Schematic;
import mindustry.game.Schematics;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static com.vndustrybackend.vndustrybackend.Vars.data;

@RestController
public class SchematicPost {
    @PostMapping("/api/v1/post/schematic")
    public ResponseEntity<Map<String, Object>> parserSchematic(@RequestBody Map<String, String> body) {
        File dataFile = data.child("data.json").file();
        String schematicB64 = body.get("schematic").replace(" ", "");
        Schematic schem = Schematics.readBase64(schematicB64);
        byte[] image = ContentHandler.parseSchematicImage(schem);

        Map<String, Integer> requirement = new HashMap<String,Integer>();


        Map<String, Object> info = new HashMap<String, Object>();
        info.put("name", schem.name());
        info.put("desc", schem.description());
        info.put("powerCon", schem.powerConsumption());
        info.put("powerProduct", schem.powerProduction());
        info.put("image", image);
        schem.requirements().each((item, amount) -> {
            requirement.put(item.name, amount);
        });
        info.put("requirements", requirement);



        return ResponseEntity.status(HttpStatus.OK).body(info);
    }
}
