package com.cgl.serviceImpl;


import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgl.dao.IUserDao;
import com.cgl.model.User;
import com.cgl.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    private IUserDao userDao;

    public IUserDao getUserDao() {
        return userDao;
    }

    @Resource
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void add(User u) {
        if (u != null) {
            logger.info("开始添加用户");
            this.userDao.add(u);
        } else {
            logger.info("未用为空");
        }
    }

}
