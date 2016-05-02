package com.cgl.action;

import com.cgl.base.baseAction.BaseAction;
import com.cgl.model.UserType;
import com.cgl.util.Page;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cgl on 2016/4/04.
 * 类名：
 * 作用
 */
public class UserTypeAction extends BaseAction implements ModelDriven<UserType> {
    private UserType userType = new UserType();
    private String ids; //批量删除

    /**
     * 查询所有
     *
     * @return
     */
    public String getAll() {
        Page p = getPageInfo();//分页
//        查出所有客户Service
        List<UserType> userTypeList = userTypeService.findAllByPage(new UserType(), getPageInfo());
        long total = userTypeService.getTotal(new UserType());
        dateMap = new HashMap<String, Object>();
        if (userTypeList != null && userTypeList.size() > 0) {
//        构造datagrid需要的json格式 ｛“total”:xx,"rows"：[x,x,x]｝
            dateMap.put("total", total); //总数
            dateMap.put("rows", userTypeList);//具体数据
        }
        return Action.SUCCESS;
    }

    /**
     * 添加用户类型
     */
    public void add() {
        if (userType != null) {
            userTypeService.add(userType);
        }
    }

    /**
     * 删除用户类型
     *
     * @return
     */
    public void delete() {
        if (ids != null) {
            userTypeService.deleteAll(new UserType(), ids);
        }
    }

    /**
     * 修改用户类型
     *
     * @return
     */
    public void update() {
        if (userType != null) {
            userTypeService.update(userType);
        }
    }

    public UserType getModel() {
        return userType;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
    
}
