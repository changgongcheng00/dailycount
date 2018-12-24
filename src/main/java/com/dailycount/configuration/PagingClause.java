package com.dailycount.configuration;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 分页从句
 */
@Data
@ApiModel(value = "分页设置")
public class PagingClause implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -867863046119673143L;

    /**
     * 当前页码
     */
    @ApiModelProperty(notes = "当前页码", example = "1", dataType = "int")
    private int no;

    /**
     * 页面大小
     */
    @ApiModelProperty(notes = "页面大小", example = "20", dataType = "int")
    private int size;

    /**
     * Default constructor.
     *
     * @param no 当前页码
     * @param size 页面大小
     */
    public PagingClause(int no, int size) {
        super();
        this.no = no;
        this.size = size;
    }

}
