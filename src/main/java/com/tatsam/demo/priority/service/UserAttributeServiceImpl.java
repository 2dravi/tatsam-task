package com.tatsam.demo.priority.service;

import com.tatsam.demo.priority.entity.AppUser;
import com.tatsam.demo.priority.entity.UserAttribute;
import com.tatsam.demo.priority.entity.dto.UserAreaPayloadDTO;
import com.tatsam.demo.priority.entity.dto.UserPriorityRatingDTO;
import com.tatsam.demo.priority.repository.AppUserRepository;
import com.tatsam.demo.priority.repository.UserAttributeRepository;
import com.tatsam.demo.priority.utility.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

public class UserAttributeServiceImpl implements UserAttributeService {

    @PersistenceContext
    EntityManager manager;
    @Autowired private UserAttributeRepository userAttributeRepository;
    @Autowired private AppUserRepository appUserRepository;

    ZonedDateTime time = ZonedDateTime.now(ZoneId.of(Constants.TIME_ZONE));
    LocalDateTime timeNow = time.toLocalDateTime();


    @Override
    public void saveUserAttributes(UserAreaPayloadDTO payloadObj) {
        UserAttribute userAttribute = new UserAttribute();
        userAttribute.setUserAreaName(payloadObj.getUserAreaName());
        userAttribute.setCreatedAt(timeNow);
        userAttributeRepository.save(userAttribute);
    }

    @Override
    public List<Object[]> getUserAttributes(Long userId) {
        Optional<AppUser> user = appUserRepository.findById(userId);
        if(user.isPresent()){
            String queryString = "SELECT n_user_id from USER_AREA_ATTRIBUTES WHERE n_user_id=:userId";
            Query query = (Query) manager.createNativeQuery(queryString);
            query.setParameter("userId",userId);
            return query.getResultList();
        }
        return null;
    }

    @Override
    public UserAttribute saveUserRatingAndPriorityForAttribute(UserPriorityRatingDTO requestPayload, AppUser appUser) {
             UserAttribute userAttribute = new UserAttribute();
             try {
                 userAttribute.setUserAreaName(requestPayload.getUserAttribute());
                 userAttribute.setUserId(appUser.getUser_id());
                 userAttribute.setPriorityEnum(requestPayload.getUserPriority());
                 userAttribute.setUserAreaName(requestPayload.getUserAttribute());
                 userAttributeRepository.save(userAttribute);
                 return userAttribute;
             }catch (Exception ex){
                 ex.getMessage();
             }
             return null;
    }
}
