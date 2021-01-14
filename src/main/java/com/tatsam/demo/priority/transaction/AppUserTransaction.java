package com.tatsam.demo.priority.transaction;

import com.tatsam.demo.priority.entity.AppUser;

public interface AppUserTransaction {
     AppUser getUserBYId(Long userId);
}
