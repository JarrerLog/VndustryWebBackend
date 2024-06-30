package com.vndustrybackend.vndustrybackend.Utils;

import java.util.HashMap;
import java.util.Objects;

public class ErrorResponse {
    public String message;
    public int code;

    public ErrorResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public HashMap<String, String> getErrString() {
        HashMap<String, String> err = new HashMap<>();
        err.put("message", message);
        err.put("code", String.valueOf(code));
        err.put("time", String.valueOf(System.currentTimeMillis()));
        return err;
    }

    public HashMap<String, Object> getErrObjects() {
        HashMap<String, Object> err = new HashMap<>();
        err.put("message", message);
        err.put("code", code);
        err.put("time", System.currentTimeMillis());
        return err;
    }

}
