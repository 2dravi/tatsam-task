package com.tatsam.demo.priority.repository;

import com.tatsam.demo.priority.entity.UserAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAttributeRepository extends JpaRepository<UserAttribute,Long> {
    // repo to perform the crud transactions

}
