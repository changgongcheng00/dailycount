package com.dailycount.service.impl;

import com.dailycount.dao.NoDao;
import com.dailycount.entity.No;
import com.dailycount.service.No1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName NoTrans1
 * @Description TODO
 * @Author cheng
 * @Date 2019/4/23 10:42
 **/
@Service
public class NoServiceImpl1 implements No1{

    @Autowired
    NoDao noDao;

    @Override
    public int insert() {
        try {
            No no = new No();
            no.setNo(1D);
            no.setDesc("no1");
            return noDao.insert(no);
        } finally {
            //throw new RuntimeException("test1");
        }
    }

}
