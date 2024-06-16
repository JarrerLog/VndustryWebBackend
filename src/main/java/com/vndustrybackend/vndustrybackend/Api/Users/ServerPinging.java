package com.vndustrybackend.vndustrybackend.Api.Users;

import org.springframework.web.bind.annotation.RestController;

import com.vndustrybackend.vndustrybackend.Handlers.ServerHandler;
import com.vndustrybackend.vndustrybackend.Utils.ErrorResponse;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.asm.TypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ServerPinging {

    @PostMapping("/api/v1/ping")
    public ResponseEntity<Map<String, String>> postMethodName(@RequestBody Map<String, String> body) {
        // TODO: process POST request

        try {

            String ip = body.get("ip");
            HashMap<String, String> map = new HashMap<>();

            ServerHandler.pingServer(ip, host -> {
                map.put("ip", ip);
                map.put("ping", String.valueOf(host.ping));
                map.put("players", String.valueOf(host.players));
                map.put("map", host.mapname);
                map.put("wave", String.valueOf(host.wave));
                map.put("version", String.valueOf(host.version));
                map.put("limit", String.valueOf(host.playerLimit));
                map.put("mode", host.modeName);

            });

            return ResponseEntity.status(HttpStatus.OK).body(map);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ErrorResponse("Invaild IP", 401).getErr());

        }

    }

}
