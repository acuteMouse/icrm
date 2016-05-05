package com.zy.testDao;

import com.zy.base.baseDao.IBaseDao;
import com.zy.model.Customer;
import com.zy.model.User;
import com.zy.util.Page;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created zy on 2016/3/22.
 * 类名：
 * 作用：
 */
public class BaseDaoImplTest {
    private static ApplicationContext act;
    @Before
    public  void getBean(){
        act=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        
    }
    
    @Test
    public void testAddEntity() throws Exception {
       IBaseDao baseDao=(IBaseDao) act.getBean("baseDao");
        User user=new User();
        user.setU_age(15);
        user.setU_address("北京");
        baseDao.addEntity(user);
      
    }

    @Test
    public void testDeleteEntity() throws Exception {
        IBaseDao baseDao=(IBaseDao) act.getBean("baseDao");
        User user = (User) baseDao.findById(1,new User());
        System.out.println(user.getU_address());
        baseDao.deleteEntity(user);
        
    }

    @Test
    public void testUpdateEntity() throws Exception {
        IBaseDao baseDao=(IBaseDao) act.getBean("baseDao");
        User user = (User) baseDao.findById(2,new User());
        user.setU_address("上海");
        baseDao.updateEntity(user);
    }

    @Test
    public void testFindAll() throws Exception {
        IBaseDao baseDao=(IBaseDao) act.getBean("baseDao");
        Page page=new Page(0,15);
        List userList= baseDao.findAllByPAge(new User(),page);
        for (Object u:userList){
            System.out.println(((User)u).getU_address());
        }
    }

    @Test
    public void testSaveOrUpdateEntity() throws Exception {
        IBaseDao baseDao= (IBaseDao) act.getBean("baseDao");
        
    }

    @Test
    public void testFindById() throws Exception {
        IBaseDao baseDao=(IBaseDao) act.getBean("baseDao");
        User user = (User) baseDao.findById(2,new User());
    }

    @Test
    public void testDeleteAll() throws Exception {
        IBaseDao baseDao=(IBaseDao) act.getBean("baseDao");
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(3);
        baseDao.deleteAll(new Customer(),ids);
    }
}