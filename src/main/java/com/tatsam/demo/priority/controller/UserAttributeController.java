package com.tatsam.demo.priority.controller;

import com.tatsam.demo.priority.entity.AppUser;
import com.tatsam.demo.priority.entity.dto.UserAreaPayloadDTO;
import com.tatsam.demo.priority.entity.dto.UserPriorityRatingDTO;
import com.tatsam.demo.priority.transaction.AppUserTransaction;
import com.tatsam.demo.priority.transaction.UserAttributeTransaction;
import com.tatsam.demo.priority.utility.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//user-area related REST endpoints
@RestController
@RequestMapping("/user-area")
public class UserAttributeController extends BaseController {

    @Autowired
    private UserAttributeTransaction userAttributeTransaction;
    @Autowired
    private AppUserTransaction appUserTransaction;

    //api to add new-user-attribute to the DB
    @PostMapping(value = "/add-area", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<ApiResponse> addUserArea(@RequestBody UserAreaPayloadDTO payloadObj) {
        ApiResponse apiResponse = this.initializeResponse("/user-area/add-area");
        try {
            apiResponse = userAttributeTransaction.createNewArea(apiResponse, payloadObj);
        } catch (Exception ex) {
            apiResponse.setMessages(ex.getMessage());
            return this.getFailureResponseEntity(apiResponse, null);
        }
        return this.getSuccessResponseEntity(apiResponse, HttpStatus.OK, null);
    }

    //api to fetch the priority areas from database
    @GetMapping(value = "/user-attribute-list/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> getUserAttributes(@RequestParam Long userId) {
        ApiResponse apiResponse = this.initializeResponse("/user-area/add-area");
        try {
            apiResponse = userAttributeTransaction.getUserAttributes(apiResponse, userId);
        } catch (Exception ex) {
            apiResponse.setMessages(ex.getMessage());
            return this.getFailureResponseEntity(apiResponse, null);
        }
        return this.getSuccessResponseEntity(apiResponse, HttpStatus.OK, null);
    }

    //api to edit the existing user attribute to update the existing priority and rating
    @PostMapping(value = "/user-attribute-priority/{user_id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    private ResponseEntity<?> postPriorityWithUserRating(@PathVariable(value = "user_id",name = "user info") Long userId , @RequestBody UserPriorityRatingDTO payload) {
        ApiResponse apiResponse = this.initializeResponse("/user-area/user-attribute-priority");
        try {
            AppUser  user = appUserTransaction.getUserBYId(userId);
            userAttributeTransaction.postUserAttributeAndRating(apiResponse, payload, user);
        } catch (Exception ex) {
            apiResponse.setMessages(ex.getMessage());
            return this.getSuccessResponseEntity(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
        return this.getSuccessResponseEntity(apiResponse, HttpStatus.OK, null);
    }

}
