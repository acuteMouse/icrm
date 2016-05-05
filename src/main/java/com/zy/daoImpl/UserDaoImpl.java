package com.zy.daoImpl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.zy.base.baseDao.impl.BaseDaoImpl;
import com.zy.dao.IUserDao;
import com.zy.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl implements IUserDao {

	public User getUserByName(User user) {
		String hql="from User where u_userName=:userName";
		Query query=getSeesion().createQuery(hql);
		query.setParameter("userName", user.getU_userName());
		return (User) query.uniqueResult();
	}
	
	

}
