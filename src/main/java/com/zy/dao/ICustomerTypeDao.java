package com.zy.dao;

import com.zy.base.baseDao.IBaseDao;
import com.zy.model.CustomerType;

/**
 * Created zy on 2016/4/2.
 * 类名：客户类型数据接口
 * 作用：
 */
public interface ICustomerTypeDao extends IBaseDao {
    CustomerType checkByTypeName(String ct_name);
}
