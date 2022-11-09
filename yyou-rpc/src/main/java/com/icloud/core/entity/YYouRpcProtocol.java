package com.icloud.core.entity;

/**
 * @author zdh
 */
public interface YYouRpcProtocol {

        /**
         *
         * @param req
         * @return
         * @throws Exception
         */
        byte[] marshallingRequest(Request req) throws Exception;


        /**
         * 解码请求
         * @param data
         * @return
         * @throws Exception
         */
        Request unmarshallingRequest(byte[] data) throws Exception;


        /**
         * 编码响应
         * @param rsp
         * @return
         * @throws Exception
         */
        byte[] marshallingResponse(Response rsp) throws Exception;


        /**
         * 解码响应
         * @param data
         * @return
         * @throws Exception
         */
        Response unmarshallingResponse(byte[] data) throws Exception;
}

