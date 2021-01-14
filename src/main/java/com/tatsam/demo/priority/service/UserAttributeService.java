package com.tatsam.demo.priority.service;

import com.tatsam.demo.priority.entity.AppUser;
import com.tatsam.demo.priority.entity.UserAttribute;
import com.tatsam.demo.priority.entity.dto.UserAreaPayloadDTO;
import com.tatsam.demo.priority.entity.dto.UserPriorityRatingDTO;
import com.tatsam.demo.priority.utility.ApiResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserAttributeService {
    void saveUserAttributes(UserAreaPayloadDTO payloadObj);
    List<Object[]> getUserAttributes(Long userId);
    UserAttribute saveUserRatingAndPriorityForAttribute(UserPriorityRatingDTO requestPayload, AppUser appUser);
}
