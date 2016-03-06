package com.cgl.testService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cgl.model.User;
import com.cgl.service.IUserService;

public class TestUserService {

	@SuppressWarnings("resource")
	@Test
	public void testAdd() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml"});
		IUserService userService=(IUserService) ctx.getBean("userService");
//		User u=new User("老大", 25);
//		userService.add(u);
	} 

}
