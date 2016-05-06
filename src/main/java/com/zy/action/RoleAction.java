package com.zy.action;

import com.zy.base.baseAction.BaseAction;
import com.zy.model.Role;
import com.zy.util.Page;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

/**
 * Created by zy on 2016/4/04.
 * 类名：
 * 作用
 */
@Controller
public class RoleAction extends BaseAction implements ModelDriven<Role> {
    private Role role = new Role();
    private String ids; //批量删除

    /**
     * 查询所有
     *
     * @return
     */
    public String getAll() {
        Page p = getPageInfo();//分页
//        查出所有客户Service
        List<Role> roleList = roleService.findAllByPage(new Role(), getPageInfo());
        long total = roleService.getTotal(new Role());
        dateMap = new HashMap<String, Object>();
        if (roleList != null && roleList.size() > 0) {
//        构造datagrid需要的json格式 ｛“total”:xx,"rows"：[x,x,x]｝
            dateMap.put("total", total); //总数
            dateMap.put("rows", roleList);//具体数据
        }
        return Action.SUCCESS;
    }

    /**
     * 添加用户，角色
     */
    public void add() {
        if (role != null) {
            roleService.add(role);
        }
    }

    /**
     * 删除角色
     *
     * @return
     */
    public void delete() {
        if (ids != null) {
            roleService.deleteAll(new Role(), ids);
        }
    }

    /**
     * 修改角色
     *
     * @return
     */
    public void update() {
        if (role != null) {
            roleService.update(role);
        }
    }

    public Role getModel() {
        return role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
    
}
