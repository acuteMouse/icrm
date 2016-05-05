package com.zy.service;

import com.zy.base.baseService.IBaseService;

/**
 * Created zy on 2016/4/2.
 * 类名：客户类型业务接口
 * 作用：
 */
public interface ICustomerTypeService extends IBaseService{
    /**
     * 验证客户类型名称是否存在
     * @param ct_name
     * @return boolean  是否存在
     */
    boolean checkByTypeName(String ct_name);

}
