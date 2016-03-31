package com.cgl.action;

import com.cgl.model.Customer;
import com.cgl.model.CustomerType;
import com.cgl.service.ICustomerService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.net.httpserver.Authenticator;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created cgl on 2016/3/30.
 * 类名：
 * 作用：客户操作类
 */
@Controller
public class CustomerAction implements ModelDriven<Customer> {
    private Map<String, Object> dateMap;
    private Customer customer = new Customer();
    @Resource
    private ICustomerService customerService;

    public String getAllCustomer() {
//        查出所有客户
        List customers = customerService.findAll(new Customer());
//        long total = customerService.getTotal(new Customer());
        long total = 0l;
//        减少一次数据库查询
        if (customers != null && customers.size() > 0) {
            total = customers.size();
        }
        dateMap = new HashMap<String, Object>();
//        构造datagrid需要的json格式 ｛“total”:xx,"rows"：[x,x,x]｝
        dateMap.put("total", total); //总数
        dateMap.put("rows", customers);//具体数据
        return Action.SUCCESS;
    }

    //    ajax加载客户类型
    public String getCustomerType(){
        List customerTypes=customerService.findAll(new CustomerType());
        dateMap=new HashMap<String, Object>();
        if (customerTypes!=null&&customerTypes.size()>0){
          dateMap.put("types",customerTypes);
        }
//        System.out.println(jsonArray.toString());
        return  Action.SUCCESS;
    }

    public Customer getModel() {
        return customer;
    }

    public Map getDateMap() {
        return dateMap;
    }

    public void setDateMap(Map dateMap) {
        this.dateMap = dateMap;
    }

  
}
