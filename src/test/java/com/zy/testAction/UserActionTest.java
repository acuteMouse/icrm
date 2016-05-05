package com.zy.testAction;

import com.zy.action.UserAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created zy on 2016/3/30.
 * 类名：
 * 作用：
 */
public class UserActionTest {

    @Test
    public void testGetAllCustomer() throws Exception {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
      UserAction userAction= (UserAction) ctx.getBean("userAction");
//        userAction.getAllCustomer();
    }
}