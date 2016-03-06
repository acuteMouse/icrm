package com.cgl.testAction;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cgl.action.UserAction;
import com.cgl.model.User;

public class TestUserAction {

	@Test
	public void testAdd() {
		@SuppressWarnings("resource")
		ApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml"});
		UserAction userAction=(UserAction) ctx.getBean("userAction");
		userAction.add();
	}

}
