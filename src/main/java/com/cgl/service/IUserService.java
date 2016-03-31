package com.cgl.service;

import com.cgl.base.baseService.IBaseService;
import com.cgl.model.User;


public interface IUserService extends IBaseService{

	User checkUser(User user);
	
	
}
