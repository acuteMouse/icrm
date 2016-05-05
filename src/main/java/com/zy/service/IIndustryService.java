package com.zy.service;

import com.zy.base.baseService.IBaseService;

/**
 * Created zy on 2016/4/2.
 * 类名：客户行业业务层
 * 作用：
 */
public interface IIndustryService extends IBaseService {
//    验证名称是否唯一
    boolean checkName(String i_name);
}
