package com.vndustrybackend.vndustrybackend.Utils;

import java.util.HashMap;

public class ErrorResponse {
    public String message;
    public int code;

    public ErrorResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public HashMap<String, String> getErr() {
        HashMap<String, String> err = new HashMap<>();
        err.put("message", message);
        err.put("code", String.valueOf(code));
        err.put("time", String.valueOf(System.currentTimeMillis()));
        return err;
    }

}
