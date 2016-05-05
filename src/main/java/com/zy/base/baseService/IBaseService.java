package com.zy.base.baseService;

import com.zy.util.Page;

import java.util.List;

/**
 * Created zy on 2016/3/19.
 * 类名：
 * 作用：
 */
public interface IBaseService <T> {
    public  void add(T t);
    public  void delete(T t);
    public  void update(T t);
    public  Object  findById(long id,T t);
    public List<Object> findAll(T t);
    public Long getTotal(T t);

    List findAllByPage(T t, Page p);
//    批量删除
    void deleteAll(T t, String ids);
}
