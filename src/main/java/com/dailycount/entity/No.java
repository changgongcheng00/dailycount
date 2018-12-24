package com.dailycount.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * no
 * @author 
 */
@Data
public class No implements Serializable {
    private Integer id;

    /**
     * 输入的数字
     */
    private Double no;

    /**
     * 输入描述
     */
    private String desc;

    private String createdBy;

    private String updatedBy;

    private Date createdAt;

    private Date updatedAt;

}