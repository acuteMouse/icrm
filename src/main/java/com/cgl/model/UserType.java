package com.cgl.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created cgl on 2016/3/15.
 * 类名：userType
 * 作用：系统用户类型。如：普通操作员，经理，部门主管，老板，客服
 */
@Entity
@Table(name = "t_userType")
public class UserType {
    
    private long ut_id;//  主键
    private String ut_name;// 类型名称
    private String ut_remark; //备注

    //----get/set方法--

    @Id
    @GeneratedValue
    public long getUt_id() {
        return ut_id;
    }

    public void setUt_id(long ut_id) {
        this.ut_id = ut_id;
    }

    public String getUt_name() {
        return ut_name;
    }

    public void setUt_name(String ut_name) {
        this.ut_name = ut_name;
    }

    public String getUt_remark() {
        return ut_remark;
    }

    public void setUt_remark(String ut_remark) {
        this.ut_remark = ut_remark;
    }
}
