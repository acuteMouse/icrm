package com.zy.testAction;

import com.zy.action.CustomerAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created zy on 2016/3/31.
 * 类名：
 * 作用：
 */
public class CustomerActionTest {
    
    
    @Test
    public void testGetAllCustomer() throws Exception {
    
    }

    @Test
    public void testGetCustomerType() throws Exception {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        CustomerAction customerAction= (CustomerAction) ctx.getBean("customerAction");
        customerAction.getCustomerType();
    }
}