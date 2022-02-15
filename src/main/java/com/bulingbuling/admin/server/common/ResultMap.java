package com.bulingbuling.admin.server.common;

import java.util.HashMap;

public class ResultMap extends HashMap<String, Object> {

    public ResultMap() {
        put("code", 200);
    }

    public static com.bulingbuling.admin.server.common.ResultMap ok(int code, Object data) {
        com.bulingbuling.admin.server.common.ResultMap r = new com.bulingbuling.admin.server.common.ResultMap();
        r.put("code", code);
        r.put("data", data);
        return r;
    }

    public static com.bulingbuling.admin.server.common.ResultMap ok(Object data) {
        com.bulingbuling.admin.server.common.ResultMap r = new com.bulingbuling.admin.server.common.ResultMap();
        r.put("data", data);
        return r;
    }

    public static com.bulingbuling.admin.server.common.ResultMap ok(String msg) {
        com.bulingbuling.admin.server.common.ResultMap r = new com.bulingbuling.admin.server.common.ResultMap();
        r.put("data", msg);
        return r;
    }

    public static com.bulingbuling.admin.server.common.ResultMap error(int code, String msg) {
        com.bulingbuling.admin.server.common.ResultMap r = new com.bulingbuling.admin.server.common.ResultMap();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static com.bulingbuling.admin.server.common.ResultMap error() {
        return error(500, "获取数据有误，请检查数据填写是否完整!");
    }

    public static com.bulingbuling.admin.server.common.ResultMap error(String msg) {
        return error(500, msg);
    }


}
