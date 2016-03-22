package com.cgl.testDao;

import com.cgl.base.baseDao.IBaseDao;
import com.cgl.base.baseDao.impl.BaseDaoImpl;
import com.cgl.model.User;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.portable.ApplicationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created cgl on 2016/3/22.
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
        List userList= baseDao.findAll(new User());
        for (Object u:userList){
            System.out.println(((User)u).getU_address());
        }
    }

    @Test
    public void testSaveOrUpdateEntity() throws Exception {

    }

    @Test
    public void testFindById() throws Exception {
        IBaseDao baseDao=(IBaseDao) act.getBean("baseDao");
        User user = (User) baseDao.findById(2,new User());
    }
    
}