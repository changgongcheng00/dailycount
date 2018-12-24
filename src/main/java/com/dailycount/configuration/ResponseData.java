package com.dailycount.configuration;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @param <T>
 */
@ApiModel(value = "响应数据")
public class ResponseData<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 327789401842513647L;

    /**
     *
     */
    public static final int SUCCESS_CODE = 0;

    /**
     *
     */
    public static final String SUCCESS_MESSAGE = "";

    /**
     * 数据集合
     */
    @ApiModelProperty(notes = "数据集合")
    private DataSetDTO<T> data;

    /**
     * 返回码
     */
    @ApiModelProperty(notes = "返回码")
    private int code;

    /**
     * 返回消息
     */
    @ApiModelProperty(notes = "返回消息")
    private String msg;

    /**
     * 返回唯一识别码
     */
    @ApiModelProperty(notes = "返回唯一识别码")
    private String key;

    /**
     * Default constructor.
     */
    public ResponseData() {
        super();
        // default ctor
    }

    /**
     * 该方法用于创建ResponseData
     *
     * @param <T>
     * @param dtoClass
     * @param items
     * @return ResponseData
     */
    public static <T> ResponseData<T> create(Class<T> dtoClass, List<T> items) {
        ResponseData<T> request = new ResponseData<>();
        request.setData(new DataSetDTO<>());
        request.getData().getItems().addAll(items);
        return request;
    }

    /**
     * 该方法用于返回成功的响应
     *
     * @param <T>
     * @return ResponseData
     */
    public static <T> ResponseData<T> success() {
        ResponseData<T> response = new ResponseData<>();
        response.setData(new DataSetDTO<>());
        response.getData().setItems(Collections.emptyList());
        response.getData().setCount(0);
        response.getData().setPage(null);
        response.setCode(SUCCESS_CODE);
        response.setMsg(SUCCESS_MESSAGE);
        return response;
    }

    /**
     * 该方法用于返回失败的响应
     *
     * @param <T>
     * @param code 状态码
     * @param message 返回消息
     * @return ResponseData
     */
    public static <T> ResponseData<T> error(int code, String message) {
        ResponseData<T> response = success();
        return response.failure(code, message);
    }

    /**
     * 该方法用于返回失败的响应
     *
     * @param <T>
     * @param code 状态码
     * @param message 返回消息
     * @param key 异常的唯一识别码
     * @return ResponseData
     */
    public static <T> ResponseData<T> error(int code, String message, String key) {
        ResponseData<T> response = success();
        response.failure(code, message);
        if (BlankUtils.isNotBlank(key)) {
            response.setKey(key);
        }

        return response;
    }

    /**
     * 该方法用于设置失败的响应
     *
     * @param code 状态码
     * @param message 返回消息
     * @return ResponseData
     */
    public ResponseData<T> failure(int code, String message) {
        this.setCode(code);
        this.setMsg(message);
        return this;
    }

    /**
     * 该方法用于从 Page 转换到 ResponseData
     *
     * @param <T> <T>
     * @param result result
     * @return ResponseData
     */
    public static <T> ResponseData<T> from(Page<T> result) {
        ResponseData<T> response = success();
        response.getData().setItems(result.getContent());
        response.getData().setCount(result.getTotalElements());
        response.getData().setPage(new PagingClause(result.getNumber() + 1, result.getSize()));
        return response;
    }

    /**
     * 该方法用于从 List 转换到 ResponseData
     *
     * @param <T>
     * @param result result
     * @return ResponseData
     */
    public static <T> ResponseData<T> from(List<T> result) {
        if (result == null) {
            result = new ArrayList<>();
        }
        ResponseData<T> response = success();
        response.setData(new DataSetDTO<>());
        response.getData().setItems(result);
        response.getData().setCount(result.size());
        response.getData().setPage(new PagingClause(1, result.size()));
        return response;
    }

    /**
     * 该方法用于 从 Model 转换到 ResponseData
     *
     * @param <T>
     * @param one one
     * @return ResponseData
     */
    public static <T> ResponseData<T> from(T one) {
        ResponseData<T> response = from(new ArrayList<>());
        response.setData(new DataSetDTO<>());
        if (one != null) {
            response.getData().getItems().add(one);
            response.getData().setCount(1);
        }
        return response;
    }

    /**
     * The getter for the data instance variable.
     *
     * @return the data
     */
    public DataSetDTO<T> getData() {
        return data;
    }

    /**
     * The setter for the data instance variable.
     *
     * @param data the data to set
     */
    public void setData(DataSetDTO<T> data) {
        this.data = data;
    }

    /**
     * The getter for the code instance variable.
     *
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * The setter for the code instance variable.
     *
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }

    /**
     * The getter for the msg instance variable.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * The setter for the msg instance variable.
     *
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * The getter for the key instance variable.
     *
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * The setter for the key instance variable.
     *
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

}
