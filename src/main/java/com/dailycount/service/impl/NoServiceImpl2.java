package com.dailycount.service.impl;

import com.dailycount.dao.NoDao;
import com.dailycount.entity.No;
import com.dailycount.service.No1;
import com.dailycount.service.No2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName NoTrans1
 * @Description TODO
 * @Author cheng
 * @Date 2019/4/23 10:42
 **/
@Service
public class NoServiceImpl2 implements No2 {

    @Autowired
    NoDao noDao;

    @Override
    @Transactional(propagation = Propagation.NEVER)
    public int insert() {
        try {
            No no = new No();
            no.setNo(2D);
            no.setDesc("no2");
            return noDao.insert(no);
        } finally {
            throw new RuntimeException("test2");
        }
    }

}
