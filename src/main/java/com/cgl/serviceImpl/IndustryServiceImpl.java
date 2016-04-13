package com.cgl.serviceImpl;

import com.cgl.base.baseService.impl.BaseServiceImpl;
import com.cgl.dao.IindustryDao;
import com.cgl.model.Industry;
import com.cgl.service.IIndustryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created cgl on 2016/4/2.
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
