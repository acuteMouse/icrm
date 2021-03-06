package com.zy.base.baseAction;

import com.zy.service.*;
import com.zy.util.Page;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created zy on 2016/3/29.
 * 类名：公共操作类
 * 作用:把所有的service注入都放在这里。所有的action都需要继承这个
 */
public class BaseAction {
    private int page;
    private int rows;
    public Map<String, Object> dateMap;

    //    分页信息，返回封装好的分页对象，子类继承直接可用
    public Page getPageInfo() {
        return new Page(page, rows);
    }

    @Resource
    protected ICustomerTypeService customerTypeService;
    @Resource
    protected ICustomerService customerService;
    @Resource
    protected IUserService userService;
    @Resource
    protected IIndustryService industryService;

    @Resource
    protected IDepartmentService departmentService;
    @Resource
    protected IRoleService roleService;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Map<String, Object> getDateMap() {
        return dateMap;
    }

    public void setDateMap(Map<String, Object> dateMap) {
        this.dateMap = dateMap;
    }
}
