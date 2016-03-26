package com.cgl.daoImpl;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.cgl.base.baseDao.impl.BaseDaoImpl;
import com.cgl.dao.IUserDao;
import com.cgl.model.User;

@Repository(value = "userDao")
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

	public User getUserByName(User user) {
		String hql="from User where u_userName=:userName";
		Query query=getSeesion().createQuery(hql);
		query.setParameter("userName", user.getU_userName());
		return (User) query.uniqueResult();
	}
	
	

}
