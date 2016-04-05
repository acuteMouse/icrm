package com.cgl.base.baseDao;

import com.cgl.util.Page;

import java.util.List;

/**
 * Created cgl on 2016/3/19.
 * 类名：基础数据操作接口
 * 作用：
 */

public interface IBaseDao  {
    public  void  addEntity(Object o); //添加
    public  void  deleteEntity(Object o);//删除
    public  void  updateEntity(Object o);//修改
    public  List<Object> findAll(Object o);//查询所有
    public  void saveOrUpdateEntity(Object o); //添加或者修改
    public  Object  findById(long id,Object o);
    public  Long getTotal(Object o);
//    分页
    List findAllByPAge(Object o, Page p);
//    批量删除
    void deleteAll(Object o, List<Integer> ids);
}
