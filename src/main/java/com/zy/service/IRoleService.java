package com.zy.service;

import com.zy.base.baseService.IBaseService;
import com.zy.model.User;

/**
 * @autor cgl
 * @time 2016/5/4.
 * 作用: 权限业务操作
 */
public interface IRoleService extends IBaseService{

    /**
     * 根据用户验证是否拥有该权限
     * @return
     * @param user
     */
    boolean findByUser(User user);
}
