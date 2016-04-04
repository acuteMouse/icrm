package com.cgl.action;

import com.cgl.base.baseAction.BaseAction;
import com.cgl.model.Customer;
import com.cgl.model.CustomerType;
import com.cgl.model.Industry;
import com.cgl.service.ICustomerService;
import com.cgl.service.ICustomerTypeService;
import com.cgl.service.IIndustryService;
import com.cgl.util.Page;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
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
public class CustomerAction extends BaseAction implements ModelDriven<Customer> {
    private Map<String, Object> dateMap;
    private Customer customer = new Customer();

    private long industryId;
    private long c_typeId;
    private int page;
    private int rows;

    //    查询所有客户,带分页
    public String getAllCustomer() {
        Page p = new Page(page, rows);//分页
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
        customerService.add(customer);
    }

    /**
     * 修改客户信息
     */
    public void updateCustomer() {
        System.out.println(customer);
        CustomerType customerType = (CustomerType) customerTypeService.findById(c_typeId, new CustomerType());
//            查询行业类型
        Industry industry = (Industry) industryService.findById(industryId, new Industry());
        customer.setC_type(customerType);
        customer.setC_industry(industry);
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

    public Map getDateMap() {
        return dateMap;
    }

    public void setDateMap(Map dateMap) {
        this.dateMap = dateMap;
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

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
