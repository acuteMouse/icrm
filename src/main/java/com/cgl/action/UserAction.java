package com.cgl.action;

import javax.annotation.Resource;

import com.cgl.base.baseService.impl.BaseServiceImpl;
import com.cgl.model.Customer;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.cgl.model.User;
import com.cgl.service.IUserService;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;
import java.util.Map;

@Controller
public class UserAction implements ModelDriven<User> {
    private User user = new User();
    @Resource
    private IUserService userService;
    private JSONObject datemap;

    /**
     * 2016-03-15 登陆
     *
     * @return
     */
    public String login() {
        User u = userService.checkUser(user);// 根据用户名获取用户信息,
        // 验证密码是否正确
        if (u != null && u.getU_password().equals(user.getU_password())) {
            ActionContext.getContext().put("user", u);
            return "loginSuccess";
        } else {
            ActionContext.getContext().put("msg", "用户名或密码错误！");
            return "loginFail";
        }
    }

    /**
     * 2016-03-20
     * 返回所有客户信息，带分页功能
     */
    
    public void getAllCustomer() {
        List customers = userService.findAll(new Customer());
        JSONObject jsonObject = new JSONObject();
        long total = userService.getTotal(new Customer());
        jsonObject.put("total", total);
        jsonObject.put("rows", customers);
    }
    
    public JSONObject getDatemap() {
        return datemap;
    }

    public void setDatemap(JSONObject datemap) {
        this.datemap = datemap;
    }

    public User getModel() {
        return user;
    }
}
