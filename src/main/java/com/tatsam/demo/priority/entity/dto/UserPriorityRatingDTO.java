package com.tatsam.demo.priority.entity.dto;

import com.google.gson.annotations.SerializedName;
import com.tatsam.demo.priority.entity.Priority;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

//dto to read the input data
@Data
public class UserPriorityRatingDTO implements Serializable {

    @SerializedName(value = "user_id")
    @NotNull
    @NotBlank
    private Long userId;

    @SerializedName(value = "user_attribute")
    @NotNull
    @NotBlank
    private String userAttribute;

    @SerializedName(value = "user_rating")
    @NotNull
    @NotBlank
    private String userRating;
    @SerializedName(value = "user_priority")
    @NotNull
    @NotBlank
    private Priority userPriority;

}
