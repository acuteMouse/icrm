package com.cgl.daoImpl;

import com.cgl.base.baseDao.impl.BaseDaoImpl;
import com.cgl.dao.IindustryDao;
import com.cgl.model.Industry;
import org.springframework.stereotype.Repository;

/**
 * Created cgl on 2016/4/2.
 * 类名：客户行业数据接口实现类
 * 作用：
 */
@Repository("industryDao")
public class IndustryDaoImpl extends BaseDaoImpl implements IindustryDao {

    public Industry checkName(String i_name) {
        return (Industry) getSeesion().createQuery("from Industry where i_name=:name").setParameter("name", i_name).uniqueResult();
    }
}
