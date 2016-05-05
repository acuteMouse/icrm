package com.zy.serviceImpl;

import com.zy.base.baseService.impl.BaseServiceImpl;
import com.zy.model.User;
import com.zy.service.IRoleService;
import org.springframework.stereotype.Service;

/**
 * @autor cgl
 * @time 2016/5/4.
 * 作用:
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl implements IRoleService {
    public boolean findByUser(User user) {
        return false;
    }
}
