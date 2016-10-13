package com.zy.action;

import com.zy.base.baseAction.BaseAction;
import com.zy.model.User;
import com.zy.model.Role;
import com.zy.service.IUserService;
import com.zy.util.Page;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserAction extends BaseAction implements ModelDriven<User> {
    private User user = new User();
    @Resource
    private IUserService userService;

    /**
     * 2016-03-15 登陆
     *
     * @return
     */
    public String login() {
        User u = userService.checkUser(user);// 根据用户名获取用户信息,
//        Map session = ActionContext.getContext().getSession(); //获取session
//        User userSession = (User) session.get("user");
        // 验证密码是否正确,验证session
        if (  u.getU_password().equals(user.getU_password())) {
            ActionContext.getContext().getSession().put("user", u);
            return "loginSuccess";
        } else {
            ActionContext.getContext().put("msg", "用户名或密码错误！");
            return "loginFail";
        }
    }
    /**
     *
     */

    /**
     * 注销，当前登陆用户，返回登陆界面
     *并清空sesion中的用户信息
     * @return
     */
    public String signOut() {
        ActionContext.getContext().getSession().remove("user");//注销session
        return "signOut";
    }

    /**
     * 查询所有
     *
     * @return
     */
    public String getAll() {
        Page p = getPageInfo();//分页
//        查出所有客户
        List<User> userList = userService.findAllByPage(new User(), getPageInfo());
        long total = userService.getTotal(new User());
        dateMap = new HashMap<String, Object>();
        if (userList != null && userList.size() > 0) {
//        构造datagrid需要的json格式 ｛“total”:xx,"rows"：[x,x,x]｝
            dateMap.put("total", total); //总数
            dateMap.put("rows", userList);//具体数据
        }
        return Action.SUCCESS;
    }

    /**
     *异步加载用户类型
     * @return
     */
   /* public  String ajaxGetAllType(){
        List userTypeList=userTypeService.findAll(new Role());
        dateMap=new HashMap<String, Object>();
        dateMap.put("types",userTypeList);
        return  Action.SUCCESS;
    }*/
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public User getModel() {
        return user;
    }
}
