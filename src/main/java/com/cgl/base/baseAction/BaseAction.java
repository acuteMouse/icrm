package com.cgl.base.baseAction;

import com.cgl.base.baseDao.impl.BaseDaoImpl;
import com.cgl.model.CustomerType;
import net.sf.json.JSONObject;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created cgl on 2016/3/29.
 * 类名：公共操作类
 * 作用：
 */
public class BaseAction {
    private Map dateMap;//返回json
    private BaseDaoImpl baseDao;

    public void getCustomerType() {

        List customerTypeList = baseDao.findAll(new CustomerType());
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("types",customerTypeList);
    }

    public Map getDateMap() {
        return dateMap;
    }

    public void setDateMap(Map dateMap) {
        this.dateMap = dateMap;
    }

    public BaseDaoImpl getBaseDao() {
        return baseDao;
    }

    @Resource
    public void setBaseDao(BaseDaoImpl baseDao) {
        this.baseDao = baseDao;
    }
}
