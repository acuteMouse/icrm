package com.cgl.dao;

import com.cgl.base.baseDao.IBaseDao;
import com.cgl.model.Industry;

/**
 * Created cgl on 2016/4/2.
 * 类名：客户行业数据操作接口
 * 作用：
 */
public interface IindustryDao extends IBaseDao {
//    根据名称搜索行业
    Industry checkName(String i_name);
}
