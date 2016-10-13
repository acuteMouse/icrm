package com.zy.testAction;

import com.zy.action.PowerAction;
import com.zy.base.baseDao.IBaseDao;
import com.zy.model.Power;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * @autor cgl
 * @time 2016/5/6.
 * 作用:
 */
public class PowerActionTest {

    @Test
    public void testGetAll() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        IBaseDao iBaseDao= (IBaseDao) applicationContext.getBean("baseDao");
        iBaseDao.findAll(new Power());
    }
}