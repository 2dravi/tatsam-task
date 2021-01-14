package com.tatsam.demo.priority.repository;

import com.tatsam.demo.priority.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
}
