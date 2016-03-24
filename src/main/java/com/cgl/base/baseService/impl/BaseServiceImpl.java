package com.cgl.base.baseService.impl;

import com.cgl.base.baseDao.IBaseDao;
import com.cgl.base.baseService.IBaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created cgl on 2016/3/19.
 * 类名： 基础业务操作，实现IbaseService 接口
 * 作用：通用业务操作层
 */
@Service("baseService")
public class BaseServiceImpl implements IBaseService {

    @Resource//注入dao
    private IBaseDao baseDao;

    public void add(Object o) {
        baseDao.addEntity(o);
    }

    public void delete(Object o) {
        baseDao.deleteEntity(o);
    }

    public void update(Object o) {
        baseDao.updateEntity(o);
    }

    public Object findById(long id, Object o) {
        return baseDao.findById(id, o);
    }

    public List<Object> findAll(Object o) {
        return baseDao.findAll(o);
    }
}
