package com.zy.serviceImpl;

import com.zy.base.baseService.impl.BaseServiceImpl;
import com.zy.dao.ICustomerDao;
import com.zy.service.ICustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created zy on 2016/3/30.
 * 类名：客户业务操作实现
 * 作用：
 */
@Service("customerService")
public class CustomerServiceImpl extends BaseServiceImpl implements ICustomerService{
    @Resource
    private ICustomerDao customerDao;
}
