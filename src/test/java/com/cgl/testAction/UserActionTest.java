package com.cgl.testAction;

import com.cgl.action.UserAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created cgl on 2016/3/30.
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