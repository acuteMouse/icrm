package com.cgl.testService;

import com.cgl.base.baseService.IBaseService;
import com.cgl.model.User;
import com.cgl.util.Page;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created cgl on 2016/3/24.
 * 类名：
 * 作用：
 */
public class BaseServiceImplTest {

    private static ApplicationContext act;

    @Before
    public void getBean() {
        act = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

    }

    @Test
    public void testAdd() throws Exception {
        IBaseService baseService = (IBaseService) act.getBean("baseService");
        User user = new User();
        user.setU_address("重庆");
        baseService.add(user);
    }

    @Test
    public void testDelete() throws Exception {
        IBaseService baseService = (IBaseService) act.getBean("baseService");
        User user = (User) baseService.findById(4, new User());
        baseService.delete(user);
    }

    @Test
    public void testUpdate() throws Exception {
        IBaseService baseService = (IBaseService) act.getBean("baseService");
        User user = (User) baseService.findById(4, new User());
        user.setU_address("广州");
        baseService.update(user);

    }

    @Test
    public void testFindById() throws Exception {
        IBaseService baseService = (IBaseService) act.getBean("baseService");
        User user = (User) baseService.findById(4, new User());
        System.out.println(user.toString());
    }

    @Test
    public void testFindAll() throws Exception {
        IBaseService baseService = (IBaseService) act.getBean("baseService");
        Page page=new Page(1,15);
        List userlist=baseService.findAll(new User());
        System.out.println(userlist.size());
    }
}