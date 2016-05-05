package com.zy.service;

import com.zy.base.baseService.IBaseService;
import com.zy.model.User;


public interface IUserService extends IBaseService{

	User checkUser(User user);
	
	
}
