package com.zy.system.Intercepts;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zy.model.User;
import com.zy.service.IRoleService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.Include;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @autor cgl
 * @time 2016/5/4.
 * 作用:权限拦截器
 */
public class CheckRoles extends AbstractInterceptor {
    //注入权限业务层
    @Resource
    private IRoleService roleService;

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Map<String, Object> session = invocation.getInvocationContext().getSession();
        String realUrl= ServletActionContext.getRequest().getRequestURL().toString();//绝对路径
//        获取相对路径
        String url=realUrl.substring(25);

        User user = (User) session.get("user");
       if ("/user/user_login.action".equals(url)||"/user/user_signOut.action".equals(url)){
            return invocation.invoke();
        }
        if (user != null) { //已登陆就验证是否有该权限
//            boolean hasPower = roleService.findByUser(user);
            boolean hasPower=true;
            if (hasPower) { //有，继续执行
                return invocation.invoke();
            } else { //没有，返回提示页面
                ActionContext.getContext().put("msg", "您未拥有该权限");
                return "noPower";
            }

        } else { //未登陆则返回登陆页面
            ActionContext.getContext().put("msg", "您尚未登陆");
            return "signOut";
        }

    }
}
