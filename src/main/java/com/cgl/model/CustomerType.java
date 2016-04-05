package com.cgl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created cgl on 2016/3/19.
 * 类名：客户类型
 * 作用：客户分类
 */
@Entity
@Table(name = "t_CustomerType")
public class CustomerType {
    private long id;//主键
    private String ct_name;//客户分类，名


    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getCt_name() {
        return ct_name;
    }

    public void setCt_name(String ct_name) {
        this.ct_name = ct_name;
    }
}
