package com.tatsam.demo.priority.entity.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//dto class to read the input data
@Data
public class UserAreaPayloadDTO {

    @SerializedName("c_user_area")
    @NotBlank
    @NotNull
    private String userAreaName;
}
