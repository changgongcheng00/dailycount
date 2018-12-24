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
@ApiModel("用户主表")
@Data
@Entity(name = "User")
public class User implements Serializable{

    private static final long serialVersionUID = -7714828483631293167L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "用户名称")
    @Column(name = "username")
    private String username;
    @ApiModelProperty(value = "用户密码")
    @Column(name = "password")
    private String password;
    @ApiModelProperty(value = "用户角色")
    @Column(name = "role")
    private String role;
    @ApiModelProperty(value = "创建时间")
    @Column(name = "createdAt")
    private Date createdAt;
    @ApiModelProperty(value = "修改时间")
    @Column(name = "updatedAt")
    private Date updatedAt;

}