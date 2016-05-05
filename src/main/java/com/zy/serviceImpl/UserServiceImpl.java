package com.zy.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.zy.base.baseService.impl.BaseServiceImpl;
import com.zy.dao.IUserDao;
import com.zy.model.User;
import com.zy.service.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements IUserService {
    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public User checkUser(User user) {
        User u = userDao.getUserByName(user);
        return u;
    }

}
