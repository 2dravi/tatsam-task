package com.tatsam.demo.priority.entity;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


//this is the entity object  which maps to the below mentioned table in DB
@Entity
@Table(name = "USER_AREA_ATTRIBUTES")
@Data
public class UserAttribute implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "n_user_area_id")
    private Long userId;

    @Column(name = "c_user_area_name",nullable = false)
    private String userAreaName;

    @Column(name = "c_user_area_priority")
    @Enumerated(value = EnumType.STRING)
    private Priority priorityEnum;

    @Column(name = "c_user_rating")
    @Enumerated(value = EnumType.STRING)
    private Rating  userRating;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "t_created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "t_lupdate_at")
    @LastModifiedDate
    private LocalDateTime lastUpdatedAt;

    //bi-directional many-to-one relation mapping by foreign key n_user_id
    @ManyToOne
    @JoinColumn(name = "n_user_id",updatable = false,nullable = false,insertable = false)
    private AppUser appUser;
}
