package com.cgl.base.baseAction;

import com.cgl.base.baseDao.impl.BaseDaoImpl;
import com.cgl.model.CustomerType;
import com.cgl.service.ICustomerService;
import com.cgl.service.ICustomerTypeService;
import com.cgl.service.IIndustryService;
import com.cgl.service.IUserService;
import com.cgl.util.Page;
import net.sf.json.JSONObject;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created cgl on 2016/3/29.
 * 类名：公共操作类
 * 作用:把所有的service注入都放在这里。所有的action都需要继承这个
 */
public class BaseAction {
    @Resource
    protected ICustomerTypeService customerTypeService;
    @Resource
    protected ICustomerService customerService;
    @Resource
    protected IUserService userService;
    protected IIndustryService industryService;
}
