package com.tatsam.demo.priority.transaction;

import com.tatsam.demo.priority.controller.BaseController;
import com.tatsam.demo.priority.entity.AppUser;
import com.tatsam.demo.priority.entity.UserAttribute;
import com.tatsam.demo.priority.entity.dto.UserAreaPayloadDTO;
import com.tatsam.demo.priority.entity.dto.UserPriorityRatingDTO;
import com.tatsam.demo.priority.service.UserAttributeService;
import com.tatsam.demo.priority.utility.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class UserAttributeTransactionImpl extends BaseController implements UserAttributeTransaction {

    @Autowired private UserAttributeService userAttributeService;


    @Override
    @Transactional(rollbackOn = Exception.class)
    public ApiResponse getUserAttributes(ApiResponse apiResponse, Long userId) {
        List<Object[]> usersList = userAttributeService.getUserAttributes(userId);
        HashMap<Object,Object[]> resData = new HashMap<>();
        for(Object[] user: usersList){
            resData.put("user",user);
        }
        apiResponse.setResponseData(resData);
        return apiResponse;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ApiResponse createNewArea(ApiResponse apiResponse, UserAreaPayloadDTO payloadData) {
        HashMap<Object,Object> resData = new HashMap<>();
        try {
            userAttributeService.saveUserAttributes(payloadData);
            resData.put("message","success");
        }catch (Exception ex){
            apiResponse.setMessages(ex.getMessage());
            resData.put("messages","Error while adding the user attribute");
            apiResponse.setPayloadJson(resData);
            log.error(ex.getMessage());
        }
         return apiResponse;

    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ApiResponse postUserAttributeAndRating(ApiResponse apiResponse, UserPriorityRatingDTO requestData, AppUser appUser) {
        HashMap<Object,Object> resData = new HashMap<>();

        try {
            UserAttribute userAttribute = userAttributeService.saveUserRatingAndPriorityForAttribute(requestData, appUser);
            resData.put("message","success");
        }catch (Exception ex){
            apiResponse.setMessages(ex.getMessage());
            resData.put("messages","Error while adding the user attribute");
            apiResponse.setPayloadJson(resData);
            log.error(ex.getMessage());
        }
        return apiResponse;
    }
}
