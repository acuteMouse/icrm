package com.cgl.dao;

import com.cgl.base.baseDao.IBaseDao;
import com.cgl.model.CustomerType;

/**
 * Created cgl on 2016/4/2.
 * 类名：客户类型数据接口
 * 作用：
 */
public interface ICustomerTypeDao extends IBaseDao {
    CustomerType checkByTypeName(String ct_name);
}
