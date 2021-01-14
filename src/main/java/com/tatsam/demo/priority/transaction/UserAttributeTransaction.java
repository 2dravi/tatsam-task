package com.tatsam.demo.priority.transaction;

import com.google.gson.JsonArray;
import com.tatsam.demo.priority.entity.AppUser;
import com.tatsam.demo.priority.entity.UserAttribute;
import com.tatsam.demo.priority.entity.dto.UserAreaPayloadDTO;
import com.tatsam.demo.priority.entity.dto.UserPriorityRatingDTO;
import com.tatsam.demo.priority.utility.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public interface UserAttributeTransaction {
    ApiResponse createNewArea(ApiResponse apiResponse, UserAreaPayloadDTO payloadData);
    ApiResponse getUserAttributes(ApiResponse apiResponse, Long userId);
    ApiResponse postUserAttributeAndRating(ApiResponse apiResponse, UserPriorityRatingDTO requestData, AppUser appUser);
}
