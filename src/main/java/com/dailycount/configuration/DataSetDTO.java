package com.dailycount.configuration;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @param <T>
 */
public class DataSetDTO<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4503702231869698698L;

    /**
     * 数据集合
     */
    @ApiModelProperty(notes = "数据集合")
    private List<T> items;

    /**
     * 数据总量
     */
    @ApiModelProperty(notes = "数据总量")
    private long count;

    /**
     * 分页设置
     */
    @ApiModelProperty(notes = "分页设置")
    private PagingClause page;

    /**
     * Default constructor.
     */
    public DataSetDTO() {
        super();
        this.items = new ArrayList<>();
    }

    /**
     * The getter for the items instance variable.
     *
     * @return the items
     */
    public List<T> getItems() {
        return items;
    }

    /**
     * The setter for the items instance variable.
     *
     * @param list the items to set
     */
    public void setItems(List<T> list) {
        this.items = list;
    }

    /**
     * The getter for the count instance variable.
     *
     * @return the count
     */
    public long getCount() {
        return count;
    }

    /**
     * The setter for the count instance variable.
     *
     * @param count the count to set
     */
    public void setCount(long count) {
        this.count = count;
    }

    /**
     * The getter for the page instance variable.
     *
     * @return the page
     */
    public PagingClause getPage() {
        return page;
    }

    /**
     * The setter for the page instance variable.
     *
     * @param page the page to set
     */
    public void setPage(PagingClause page) {
        this.page = page;
    }

}
