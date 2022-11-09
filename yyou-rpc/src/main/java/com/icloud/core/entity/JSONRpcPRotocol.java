package com.icloud.core.entity;

import com.alibaba.fastjson.JSONObject;

public class JSONRpcPRotocol implements YYouRpcProtocol
{
    @Override
    public byte[] marshallingRequest(Request req) throws Exception {
        return JSONObject.toJSONBytes(req);
    }

    @Override
    public Request unmarshallingRequest(byte[] data) throws Exception {
        return JSONObject.parseObject(data, Request.class);
    }

    @Override
    public byte[] marshallingResponse(Response rsp) throws Exception {
        return JSONObject.toJSONBytes(rsp);
    }

    @Override
    public Response unmarshallingResponse(byte[] data) throws Exception {
        return JSONObject.parseObject(data, Response.class);
    }
}
