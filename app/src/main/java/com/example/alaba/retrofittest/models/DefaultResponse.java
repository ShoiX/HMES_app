package com.example.alaba.retrofittest.models;

public class DefaultResponse {
    private boolean error;

    private String msg;

    public DefaultResponse(boolean err, String mesg){
        this.error = err;
        this.msg = mesg;
    }

    public boolean isError() {
        return error;
    }

    public String getMsg() {
        return msg;
    }
}
