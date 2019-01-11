package com.example.restfuldemo.common;

import org.springframework.http.HttpStatus;

public class BaseResult {
    private int code= HttpStatus.OK.value();

    private String msg= HttpStatus.OK.getReasonPhrase();

    private Object data;


    public BaseResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResult() {
        super();
    }

    public BaseResult(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public BaseResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public BaseResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public BaseResult setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "BaseResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
