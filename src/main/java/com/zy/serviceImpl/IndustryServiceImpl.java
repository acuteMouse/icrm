package com.zy.serviceImpl;

import com.zy.base.baseService.impl.BaseServiceImpl;
import com.zy.dao.IindustryDao;
import com.zy.model.Industry;
import com.zy.service.IIndustryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created zy on 2016/4/2.
 * 类名：
 * 作用：
 */
@Service("industryService")
public class IndustryServiceImpl extends BaseServiceImpl implements IIndustryService {
    @Resource
    private IindustryDao industryDao;
    public boolean checkName(String i_name) {
        Industry industry=industryDao.checkName(i_name);
//        不等于空，说明已经存在
        if (industry!=null){
            return true;
        }else {
            return false;
        }
    }
}
