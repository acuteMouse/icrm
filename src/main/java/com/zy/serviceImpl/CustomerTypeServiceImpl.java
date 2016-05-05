package com.zy.serviceImpl;

import com.zy.base.baseService.impl.BaseServiceImpl;
import com.zy.dao.ICustomerTypeDao;
import com.zy.model.CustomerType;
import com.zy.service.ICustomerTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created zy on 2016/4/2.
 * 类名：客户类型业务实现
 * 作用：
 */
@Service("customerTypeService")
public class CustomerTypeServiceImpl extends BaseServiceImpl implements ICustomerTypeService {
    @Resource
    private ICustomerTypeDao customerTypeDao;

    public boolean checkByTypeName(String ct_name) {
        CustomerType customerType = customerTypeDao.checkByTypeName(ct_name);
        if (customerType != null) { //不等于空，即已经存在,return false
            return true;
        } else {
            return false;
        }
    }
}
