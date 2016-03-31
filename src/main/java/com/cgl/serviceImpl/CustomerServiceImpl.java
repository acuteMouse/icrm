package com.cgl.serviceImpl;

import com.cgl.base.baseDao.impl.BaseDaoImpl;
import com.cgl.base.baseService.impl.BaseServiceImpl;
import com.cgl.dao.ICustomerDao;
import com.cgl.service.ICustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created cgl on 2016/3/30.
 * 类名：客户业务操作实现
 * 作用：
 */
@Service("customerService")
public class CustomerServiceImpl extends BaseServiceImpl implements ICustomerService{
    @Resource
    private ICustomerDao customerDao;
}
