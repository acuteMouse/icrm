package com.cgl.model;

import javax.persistence.*;

/**
 * Created cgl on 2016/3/15.
 * 类名：department
 * 作用：用户部门类
 */
@Entity
@Table(name = "t_department")
public class Department {
    
    private long d_id;//主键
    private String d_name;//部门名称
    private Department d_parentDeparment; //上级部门

 

    @Id
    @GeneratedValue
    public long getD_id() {
        return d_id;
    }

    public void setD_id(long d_id) {
        this.d_id = d_id;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }
    
    @ManyToOne
    @JoinColumn(name = "d_parentDepartment")
    public Department getD_parentDeparment() {
        return d_parentDeparment;
    }

    public void setD_parentDeparment(Department d_parentDeparment) {
        this.d_parentDeparment = d_parentDeparment;
    }
}
