package com.dailycount.service;

import com.dailycount.dao.NoDao;
import com.dailycount.entity.No;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName NoServiceImpl
 * @Description TODO
 * @Author cheng
 * @Date 2018/12/24 18:14
 **/
public class NoServiceImpl implements NoService {

    @Autowired
    private NoDao noDao;

    @Override
    public List<No> findList(No no) {
        return noDao.findList(no);
    }

    @Override
    public No findById(int id) {
        return noDao.findById(id);
    }

    @Override
    public int deleteById(int id) {
        return noDao.deleteById(id);
    }

    @Override
    public int insert(No no) {
        return noDao.insert(no);
    }

    @Override
    public int updateById(No no) {
        return noDao.updateById(no);
    }
}
