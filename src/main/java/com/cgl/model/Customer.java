package com.cgl.model;

import javax.persistence.*;

/**
 * Created cgl on 2016/3/15.
 * 类名：customer
 * 作用：客户类
 */
@Entity
@Table(name = "t_customer")
public class Customer {
    private  long c_id;//主键
    private  String c_name;//客户名称。公司名称
    private  Long c_telphone; // 客户联系电话
    private  String c_address; //客户位置
    private  Industry c_industry;//客户行业，外键
    private  CustomerType c_type;//客户类型，外键
    private  String  c_email;// 邮箱

   

    @Id
    @GeneratedValue
    public long getC_id() {
        return c_id;
    }

    public void setC_id(long c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public Long getC_telphone() {
        return c_telphone;
    }

    public void setC_telphone(Long c_telphone) {
        this.c_telphone = c_telphone;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }
    
    @ManyToOne
    @JoinColumn(name = "c_industry")
    public Industry getC_industry() {
        return c_industry;
    }

    public void setC_industry(Industry c_industry) {
        this.c_industry = c_industry;
    }
    
    @ManyToOne
    @JoinColumn(name = "c_type")
    public CustomerType getC_type() {
        return c_type;
    }

    public void setC_type(CustomerType c_type) {
        this.c_type = c_type;
    }

    public String getC_email() {
        return c_email;
    }

    public void setC_email(String c_email) {
        this.c_email = c_email;
    }
}
