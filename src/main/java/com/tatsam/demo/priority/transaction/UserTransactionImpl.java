package com.tatsam.demo.priority.transaction;

import com.tatsam.demo.priority.entity.AppUser;
import com.tatsam.demo.priority.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTransactionImpl implements AppUserTransaction{

    @Autowired
    AppUserService appUserService;

    @Override
    public AppUser getUserBYId(Long userId) {
        return (AppUser) appUserService.findAppUserById(userId);
    }
}
