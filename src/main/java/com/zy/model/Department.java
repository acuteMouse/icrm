package com.zy.model;

import javax.persistence.*;

/**
 * Created zy on 2016/3/15.
 * 类名：department
 * 作用：用户部门类
 */
@Entity
@Table(name = "t_department")
public class Department {

    private long id;//主键
    private String d_name;//部门名称
    private Department d_parentDeparment; //上级部门


    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
