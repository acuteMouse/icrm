package com.cgl.base.baseService;

import java.util.List;

/**
 * Created cgl on 2016/3/19.
 * 类名：
 * 作用：
 */
public interface IBaseService {
    public  void add(Object o);
    public  void delete(Object o);
    public  void update(Object o);
    public  Object  findById(long id,Object o);
    public List<Object> findAll(Object o);
}
