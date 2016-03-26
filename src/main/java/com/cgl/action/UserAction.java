package com.cgl.action;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.cgl.model.User;
import com.cgl.service.IUserService;
import com.opensymphony.xwork2.ActionContext;

@Controller
public class UserAction implements ModelDriven<User> {
    private User user = new User();
    private IUserService userService;
    private static final Logger logger = Logger.getLogger(UserAction.class);

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
            return "success";
        } else {
            ActionContext.getContext().put("msg", "用户名或密码错误！");
            return "fail";
        }
    }

    @Resource
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }


    public User getModel() {
        return user;
    }
}
