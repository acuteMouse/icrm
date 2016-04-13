package com.cgl.testAction;

import com.cgl.action.CustomerTypeAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by cgl on 2016/4/13.
 * 类名：
 * 作用
 */
public class CustomerTypeActionTest {

    @Test
    public void testGetAll() throws Exception {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        CustomerTypeAction customerTypeAction= (CustomerTypeAction) ctx.getBean("customerTypeAction");
        customerTypeAction.getAll();
    }
}