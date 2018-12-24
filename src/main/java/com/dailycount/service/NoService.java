package com.dailycount.service;

import com.dailycount.entity.No;

import java.util.List;

public interface NoService {

    List<No> findList(No no);

    No findById(int id);

    int deleteById(int id);

    int insert(No no);

    int updateById(No no);
}
