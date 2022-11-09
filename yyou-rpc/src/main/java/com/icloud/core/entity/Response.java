package com.icloud.core.entity;

import lombok.*;

/**
 * @author zdh
 */

@Getter
@Setter
@Data
public class Response {

    /**
     *响应结果状态
     */
    private int status;

    /**
     *响应结果值
     */
    private Object returnValue;

    private Exception exception;


    public Response(int status){
        this.status =status;
    }

    public Response(Exception e){
        this.status = 400;
        this.exception = e;
    }



}
