package com.cgl.testDao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cgl.dao.IUserDao;
import com.cgl.model.User;

public class testDao {
	
	@SuppressWarnings("resource")
	@Test
	public void testAdd(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext(new String[]{"classpath:applicationContext.xml"});
			IUserDao userDao=(IUserDao) ctx.getBean("userDao");
		
//			userDao.add(u);
			
	}
}
