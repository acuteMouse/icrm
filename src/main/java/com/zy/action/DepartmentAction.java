package com.zy.action;

import com.zy.base.baseAction.BaseAction;
import com.zy.model.Department;
import com.zy.util.Page;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zy on 2016/4/04.
 * 类名：部门操作类
 * 作用
 */
public class DepartmentAction extends BaseAction implements ModelDriven<Department> {
    private Department department = new Department();//部门
    private String ids; //批量删除用

    /**
     * 查询所有
     *
     * @return
     */
    public String getAll() {
        Page p = getPageInfo();//分页
//        查出所有客户Service
        List<Department> departmentList = departmentService.findAllByPage(new Department(), getPageInfo());
        long total = departmentService.getTotal(new Department());
        dateMap = new HashMap<String, Object>();
        if (departmentList != null && departmentList.size() > 0) {
//        构造datagrid需要的json格式 ｛“total”:xx,"rows"：[x,x,x]｝
            dateMap.put("total", total); //总数
            dateMap.put("rows", departmentList);//具体数据
        }
        return Action.SUCCESS;
    }

    /**
     * 添加部门
     */
    public void add() {
        if (department != null) {
            departmentService.add(department);
        }
    }

    /**
     * 删除部门
     *
     * @return
     */
    public void delete() {
        if (ids != null) {
            departmentService.deleteAll(new Department(), ids);
        }
    }

    /**
     * 修改部门
     *
     * @return
     */
    public void update() {
        if (department != null) {
            departmentService.update(department);
        }
    }

    /**
     * 异步加载部门，添加用户时用
     *
     * @return
     */
    public String ajaxGetAll() {
        List departmentList = departmentService.findAll(new Department());
        dateMap = new HashMap<String, Object>();
        dateMap.put("departments", departmentList);
        return Action.SUCCESS;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public Department getModel() {
        return department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
