package com.dailycount.dao;

import com.dailycount.entity.No;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoDao {

    List<No> findList(No no);

    No findById(int id);

    int deleteById(int id);

    int insert(No no);

    int updateById(No no);
}