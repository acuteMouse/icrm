package com.zy.action;

import com.zy.base.baseAction.BaseAction;
import com.zy.model.Customer;
import com.zy.model.CustomerType;
import com.zy.model.Industry;
import com.zy.model.User;
import com.zy.util.Page;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

/**
 * Created zy on 2016/3/30.
 * 类名：
 * 作用：客户操作类
 */
@Controller
public class CustomerAction extends BaseAction implements ModelDriven<Customer> {
    private Customer customer = new Customer();
    private long industryId;
    private long c_typeId;
    private String ids;//删除用，支持批量

    //    查询所有客户,带分页
    public String getAllCustomer() {
        Page p = getPageInfo();//分页
//        查出所有客户
        List customers = customerService.findAllByPage(new Customer(), p);
        long total = customerService.getTotal(new Customer());
        if (customers != null && customers.size() > 0) {
            dateMap = new HashMap<String, Object>();
//        构造datagrid需要的json格式 ｛“total”:xx,"rows"：[x,x,x]｝
            dateMap.put("total", total); //总数
            dateMap.put("rows", customers);//具体数据
        }
        return Action.SUCCESS;
    }

    /**
     * 添加客户
     *
     * @return
     */
    public void addCustomer() {
//        查询客户类型
        CustomerType customerType = (CustomerType) customerTypeService.findById(c_typeId, new CustomerType());
//            查询行业类型
        Industry industry = (Industry) industryService.findById(industryId, new Industry());
        customer.setC_type(customerType);
        customer.setC_industry(industry);
        User loginUser = new User();
        if (customer.getC_user() == null) {
            loginUser = (User) ActionContext.getContext().getSession().get("user");//获取当前登陆用户，默认是当前登陆用户
            customer.setC_user(loginUser);
        }

        customerService.add(customer);
    }

    /**
     * 删除用户
     */
    public void deleteCustomer() {
        customerService.deleteAll(new Customer(), ids);
    }

    /**
     * 修改客户信息
     */
    public void updateCustomer() {
        CustomerType customerType = (CustomerType) customerTypeService.findById(c_typeId, new CustomerType());
//            查询行业类型
        Industry industry = (Industry) industryService.findById(industryId, new Industry());
        customer.setC_industry(industry);
        customer.setC_type(customerType);
        customerService.update(customer);

    }

    //    ajax加载客户类型
    public String getCustomerType() {
//        查询所有客户类型
        List customerTypes = customerService.findAll(new CustomerType());
        dateMap = new HashMap<String, Object>();
//        封装返回json
        if (customerTypes != null && customerTypes.size() > 0) {
            dateMap.put("types", customerTypes);
        }
//        System.out.println(jsonArray.toString());
        return Action.SUCCESS;
    }

    //    ajax 加载客户行业类型
    public String getIndustryType() {
        //查询所有行业
        List industrtTypes = customerService.findAll(new Industry());
        dateMap = new HashMap<String, Object>();
//        封装json
        if (industrtTypes != null && industrtTypes.size() > 0) {
            dateMap.put("types", industrtTypes);
        }
        return Action.SUCCESS;
    }

    public Customer getModel() {
        return customer;
    }


    public long getIndustryId() {
        return industryId;
    }

    public void setIndustryId(long industryId) {
        this.industryId = industryId;
    }

    public long getC_typeId() {
        return c_typeId;
    }

    public void setC_typeId(long c_typeId) {
        this.c_typeId = c_typeId;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
