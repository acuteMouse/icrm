package com.cgl.base.baseService.impl;

import com.cgl.base.baseDao.IBaseDao;
import com.cgl.base.baseService.IBaseService;
import com.cgl.model.Customer;
import com.cgl.util.Page;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created cgl on 2016/3/19.
 * 类名： 基础业务操作，实现IbaseService 接口
 * 作用：通用业务操作层
 */
public class BaseServiceImpl implements IBaseService {

    @Resource//注入dao
    protected IBaseDao baseDao;

    //    增加
    public void add(Object o) {
        baseDao.addEntity(o);
    }

    //     删除
    public void delete(Object o) {
        baseDao.deleteEntity(o);
    }

    //        修改
    public void update(Object o) {
        baseDao.updateEntity(o);
    }

    //    根据id查找
    public Object findById(long id, Object o) {
        return baseDao.findById(id, o);
    }

    //        找到所有
    public List<Object> findAll(Object o) {
        return baseDao.findAll(o);
    }

    //    找到对应表的记录条数
    public Long getTotal(Object o) {
        Long total = baseDao.getTotal(o);
        return total == null ? 0 : total;
    }

    //分页查询
    public List findAllByPage(Object o, Page p) {
        return baseDao.findAllByPAge(o, p);
    }

    public void deleteAll(Customer customer, String ids) {
        List<Integer> idList=new ArrayList<Integer>();
        String[] idStrings = ids.split(",");
        for (int i = 0; i < idStrings.length; i++) {
            idList.add(Integer.parseInt(idStrings[i]));
        }

        baseDao.deleteAll(customer, idList);
    }
}

