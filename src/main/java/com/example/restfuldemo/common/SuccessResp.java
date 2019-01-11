package com.example.restfuldemo.common;

import org.springframework.http.HttpStatus;

public class SuccessResp extends BaseResult {
    public SuccessResp(){
//        super(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),null);
        this.setCode(HttpStatus.OK.value()).setMsg(HttpStatus.OK.getReasonPhrase());
    }

    public SuccessResp(Object data){
//        super(HttpStatus.OK.value(),HttpStatus.OK.getReasonPhrase(),data);
        this.setCode(HttpStatus.OK.value()).setMsg(HttpStatus.OK.getReasonPhrase()).setData(data);
    }
}
