package com.catfact.api.payload.login;

import org.apache.groovy.json.internal.LazyMap;

import java.util.Map;

public class RequestApiLogin {
    public RequestApiLogin(Map<String, String> map) {
        setHeader();
        setJson(map);
    }

    private static LazyMap json;

    private LazyMap header;

    public LazyMap getHeader() {
        return header;
    }

    public LazyMap getJson() {
        return json;
    }

    public void setHeader() {
        header = new LazyMap();
        header.put("Content-Type", "application/json");
    }

    public void setJson(Map<String, String> map) {
        json = new LazyMap();
        json.put("usuario", map.get("usuario"));
        json.put("senha", map.get("senha"));
    }
}
