package com.cgl.action;

import com.cgl.base.baseAction.BaseAction;
import com.cgl.model.Customer;
import com.cgl.model.CustomerType;
import com.cgl.util.Page;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cgl on 2016/4/02
 * 类名：
 * 作用:客户类型操作类
 */
@Controller
public class CustomerTypeAction extends BaseAction implements ModelDriven<CustomerType> {
    private Map<String, Object> dateMap;
    private CustomerType customerType = new CustomerType();
    private String ids;//删除用，支持批量
    private String ct_name;

    /**
     * 查询所有客户类型
     *
     * @return
     */
    public String getAll() {
        Page page = getPageInfo();
        List customerTypeList = customerTypeService.findAllByPage(new CustomerType(), page);
        long total = customerService.getTotal(new CustomerType());
        if (customerTypeList != null && customerTypeList.size() > 0) {
            dateMap = new HashMap<String, Object>();
//        构造datagrid需要的json格式 ｛“total”:xx,"rows"：[x,x,x]｝
            dateMap.put("total", total); //总数
            dateMap.put("rows", customerTypeList);//具体数据
        }
        return Action.SUCCESS;
    }

    /**
     * 添加客户类型
     */
    public void add() {
        if (customerType != null) {
            customerTypeService.add(customerType);
        }
    }

    /**
     * 删除类型
     *
     * @return
     */
    public void delete() {
        if (ids != null) {
            customerTypeService.deleteAll(new CustomerType(), ids);
        }
    }

    /**
     * 修改客户类型
     *
     * @return
     */
    public void update() {
            if (customerType!=null){
                customerTypeService.update(customerType);
            }
    }

    /**
     * 异步验证要添加或者修改的 客户类型是否已经存在
     *
     * @return
     */
    public String checkTypeIsExited() {
        if (customerType!=null&&customerType.getCt_name() != null && !"".equals(customerType.getCt_name())) {
            boolean isExited = customerTypeService.checkByTypeName(customerType.getCt_name());
            dateMap = new HashMap<String, Object>();
            if (isExited) {
                dateMap.put("msg", "已存在");
            } else {
                dateMap.put("msg", "可用");
            }
        }
        return Action.SUCCESS;
    }

    public CustomerType getModel() {
        return customerType;
    }

    public Map<String, Object> getDateMap() {
        return dateMap;
    }

    public void setDateMap(Map<String, Object> dateMap) {
        this.dateMap = dateMap;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getCt_name() {
        return ct_name;
    }

    public void setCt_name(String ct_name) {
        this.ct_name = ct_name;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
