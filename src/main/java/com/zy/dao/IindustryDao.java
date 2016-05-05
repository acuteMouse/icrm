package com.zy.dao;

import com.zy.base.baseDao.IBaseDao;
import com.zy.model.Industry;

/**
 * Created zy on 2016/4/2.
 * 类名：客户行业数据操作接口
 * 作用：
 */
public interface IindustryDao extends IBaseDao {
//    根据名称搜索行业
    Industry checkName(String i_name);
}
