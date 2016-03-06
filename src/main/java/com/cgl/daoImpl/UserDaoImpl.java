package com.cgl.daoImpl;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgl.dao.IUserDao;
import com.cgl.model.User;

@Repository(value = "userDao")
public class UserDaoImpl implements IUserDao {
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Transactional
	public void add(User u) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();

	}

}
