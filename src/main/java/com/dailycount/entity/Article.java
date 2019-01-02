package com.dailycount.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Article
 * @Description TODO
 * @Author cheng
 * @Date 2018/12/31 13:13
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    private String title;
    private String content;
    private String url;
}
