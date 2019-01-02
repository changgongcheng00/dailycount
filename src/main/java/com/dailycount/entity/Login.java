package com.dailycount.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * user
 * @author 
 */
@Data
public class Login {
    private String username;
    private String password;

}