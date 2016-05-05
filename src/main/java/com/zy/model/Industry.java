package com.zy.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created zy on 2016/3/19.
 * 类名：行业
 * 作用：客户行业分类
 */
@Entity
@Table(name = "t_industry")
public class Industry {
    private long id;//主键
    private String i_name;//行业名称

    
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getI_name() {
        return i_name;
    }

    public void setI_name(String i_name) {
        this.i_name = i_name;
    }
}
