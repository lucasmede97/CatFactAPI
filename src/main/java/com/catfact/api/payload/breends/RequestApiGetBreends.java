package com.catfact.api.payload.breends;

import org.apache.groovy.json.internal.LazyMap;

import java.util.Map;

public class RequestApiGetBreends {
    public RequestApiGetBreends(Map<String, String> map) {
        setHeader();
        setParams(map);
    }

    private static LazyMap header;

    private static LazyMap params;

    public LazyMap getHeader() {
        return header;
    }

    public LazyMap getParams() {
        return params;
    }

    public void setHeader() {
        header = new LazyMap();
        header.put("Content-Type", "application/json");
    }

    public void setParams(Map<String, String> map) {
        params = new LazyMap();
        params.put("limit", map.get("limit"));
    }
}
