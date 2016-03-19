package com.cgl.action;

import javax.annotation.Resource;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import com.cgl.model.User;
import com.cgl.service.IUserService;

@Controller
public class UserAction implements ModelDriven<User> {
//    private User user=new User();//光声明的话页面的值是传不进来的
    private IUserService userService;
    private static final Logger logger = Logger.getLogger(UserAction.class);


    public String add() {
        logger.info("action 执行");
        userService.add(getModel());
        return "add";
    }


    @Resource
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public User getModel() {
        return new User();
    }
}
