package com.cgl.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created cgl on 2016/3/22.
 * 类名：
 * 作用：
 */
 public class SessionUitl {
    @Resource
    private static SessionFactory sessionFactory;

    public static Session getSeesion() {
            return sessionFactory.getCurrentSession();
    }
}
