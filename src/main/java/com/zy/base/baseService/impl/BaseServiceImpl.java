package com.zy.base.baseService.impl;

import com.zy.base.baseDao.IBaseDao;
import com.zy.base.baseService.IBaseService;
import com.zy.util.Page;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created zy on 2016/3/19.
 * 类名： 基础业务操作，实现IbaseService 接口
 * 作用：通用业务操作层
 */
public class BaseServiceImpl <T> implements IBaseService <T> {

    @Resource//注入dao
    protected IBaseDao baseDao;

    //    增加
    public void add(T t) {
        baseDao.addEntity(t);
    }

    //     删除
    public void delete(T t) {
        baseDao.deleteEntity(t);
    }

    //        修改
    public void update(T t) {
        baseDao.updateEntity(t);
    }

    //    根据id查找
    public Object findById(long id, T t) {
        return baseDao.findById(id, t);
    }

    //        找到所有
    public List<Object> findAll(T t) {
        return baseDao.findAll(t);
    }

    //    找到对应表的记录条数
    public Long getTotal(T t) {
        Long total = baseDao.getTotal(t);
        return total == null ? 0 : total;
    }

    //分页查询
    public List findAllByPage(T t, Page p) {
        return baseDao.findAllByPAge(t, p);
    }

    public void deleteAll(T t, String ids) {
        List<Integer> idList=new ArrayList<Integer>();
        String[] idStrings = ids.split(",");
        for (int i = 0; i < idStrings.length; i++) {
            idList.add(Integer.parseInt(idStrings[i]));
        }

        baseDao.deleteAll(t, idList);
    }

}

