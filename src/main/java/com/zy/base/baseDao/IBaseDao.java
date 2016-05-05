package com.zy.base.baseDao;

import com.zy.util.Page;

import java.util.List;

/**
 * Created zy on 2016/3/19.
 * 类名：基础数据操作接口
 * 作用：
 */

public interface IBaseDao<T> {
    public void addEntity(T t); //添加

    public void deleteEntity(T t);//删除

    public void updateEntity(T t);//修改

    public List<T> findAll(T t);//查询所有

    public void saveOrUpdateEntity(T t); //添加或者修改

    public T findById(long id, T t);

    public Long getTotal(T t);

    //    分页
    public List<T> findAllByPAge(T t, Page p);

    //    批量删除
    public void deleteAll(T t, List<Integer> ids);

}
