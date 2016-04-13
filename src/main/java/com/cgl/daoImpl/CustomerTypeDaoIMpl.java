package com.cgl.daoImpl;

import com.cgl.base.baseDao.impl.BaseDaoImpl;
import com.cgl.dao.ICustomerTypeDao;
import com.cgl.model.CustomerType;
import org.springframework.stereotype.Repository;

/**
 * Created cgl on 2016/4/2.
 * 类名：客户类型操作接口实现
 * 作用：
 */
@Repository("customerTypeDao")
public class CustomerTypeDaoImpl extends BaseDaoImpl implements ICustomerTypeDao {
    /**
     * 根据名称查找 客户类型
     * @param ct_name
     * @return
     */
    public CustomerType checkByTypeName(String ct_name) {
        return (CustomerType) getSeesion().createQuery("from CustomerType where ct_name=:ct_name").setParameter("ct_name", ct_name).uniqueResult();
    }
}
