package com.cgl.serviceImpl;

import com.cgl.base.baseService.impl.BaseServiceImpl;
import com.cgl.dao.ICustomerTypeDao;
import com.cgl.daoImpl.CustomerTypeDaoImpl;
import com.cgl.model.CustomerType;
import com.cgl.service.ICustomerTypeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created cgl on 2016/4/2.
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
