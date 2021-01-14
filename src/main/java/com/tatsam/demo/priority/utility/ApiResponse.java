package com.tatsam.demo.priority.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ApiResponse {
    private static final long serialVersionUID = -2479877644814765244L;
    private Integer appStatusCode = 0;

    private HashMap<Object,Object> payloadJson = null;
    private HashMap<Object,Object[]> responsePayload = null;
    private String messages ="";

    private String apiCall = "";

    private Class<?> payloadClass = Object.class;

    private String requestId = "";

    public ApiResponse(String apiCall, String requestId) {
        this.apiCall = apiCall;
        this.requestId = requestId;
    }
    public ApiResponse(String responseMessage){
        this.messages = responseMessage;
    }

    public String setMessage(){
        return this.messages;
    }

    public void setMessages(final String messages) {
        this.messages = messages;
    }

    public void setPayloadJson(final HashMap<Object,Object> resData){
        this.payloadJson=resData;
    }

    public void setResponseData(final HashMap<Object,Object[]> responseData){
        this.responsePayload = responseData;
    }
}
