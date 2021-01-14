package com.tatsam.demo.priority.controller;

import com.tatsam.demo.priority.utility.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

//BaseClass for the rest of the controllers
@Slf4j
public class BaseController {

    //method to initialize the response with the endpoint . This serves as the origin of exception
    public ApiResponse initializeResponse(String message) {
        log.debug("API End point {}", message);
        return new ApiResponse(message, UUID.randomUUID().toString());
    }
    //method to return the success response
    public ResponseEntity<ApiResponse> getSuccessResponseEntity(ApiResponse response, HttpStatus status, HttpHeaders httpHeaders) {
        return new ResponseEntity(response, httpHeaders, status);
    }
    //method to return the internal server error
    public ResponseEntity<ApiResponse> getFailureResponseEntity(ApiResponse response, HttpHeaders httpHeaders) {
        return new ResponseEntity(response, httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
