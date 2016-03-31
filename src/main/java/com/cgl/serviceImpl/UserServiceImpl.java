package com.cgl.serviceImpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.cgl.base.baseService.impl.BaseServiceImpl;
import com.cgl.dao.IUserDao;
import com.cgl.model.User;
import com.cgl.service.IUserService;

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
