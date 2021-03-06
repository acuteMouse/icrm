package com.zy.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.annotation.Resource;

/**
 * Created by zy on 2016/5/1.
 * 类名：sessionUtil
 * 作用:获取hibernateSession的工具类
 */

public class SessionUitl {
    @Resource//注入sessionfactory
    public SessionFactory sessionFactory;

    public Session getSeesion() { //返回session，由spring管理
        return sessionFactory.getCurrentSession();
    }
}
