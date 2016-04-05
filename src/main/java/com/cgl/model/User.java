package com.cgl.model;


import javax.persistence.*;
import java.util.Date;

/**
 * 系统用户类
 *
 * @陈桂林 2016-03-15
 * 类名：user
 * 作用：系统用户类，对应数据库表 t_user
 */
@Entity
@Table(name = "t_user")
public class User {
    private long id;  //主键
    private String u_userName;  //登陆系统帐号
    private String u_password;  //登陆密码
    private String u_trueName; //真实姓名
    private String u_sex;   //性别
    private String u_telphone; //联系电话
    private String u_address;  //地址
    private int u_age;            //年龄
    private Long u_idNum;        //身份证号，唯一
    private Department u_department; //所属部门，外键
    private UserType u_userType;   //用户类型，外键
    private String u_remark;   //备注
    private Date u_startDate;   //入职时间
    
    //无参构造器
    public User() {
    }
    

    //-----get/set
    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getU_userName() {
        return u_userName;
    }

    public void setU_userName(String u_userName) {
        this.u_userName = u_userName;
    }

    public String getU_password() {
        return u_password;
    }

    public void setU_password(String u_password) {
        this.u_password = u_password;
    }

    public String getU_trueName() {
        return u_trueName;
    }

    public void setU_trueName(String u_trueName) {
        this.u_trueName = u_trueName;
    }

    public String getU_sex() {
        return u_sex;
    }

    public void setU_sex(String u_sex) {
        this.u_sex = u_sex;
    }

    public String getU_telphone() {
        return u_telphone;
    }

    public void setU_telphone(String u_telphone) {
        this.u_telphone = u_telphone;
    }

    public String getU_address() {
        return u_address;
    }

    public void setU_address(String u_address) {
        this.u_address = u_address;
    }

    public int getU_age() {
        return u_age;
    }

    public void setU_age(int u_age) {
        this.u_age = u_age;
    }

    public Long getU_idNum() {
        return u_idNum;
    }

    public void setU_idNum(Long u_idNum) {
        this.u_idNum = u_idNum;
    }

    @OneToOne
    @JoinColumn(name = "u_department")
    public Department getU_department() {
        return u_department;
    }

    public void setU_department(Department u_department) {
        this.u_department = u_department;
    }

    @OneToOne
    @JoinColumn(name = "u_userType")
    public UserType getU_userType() {
        return u_userType;
    }

    public void setU_userType(UserType u_userType) {
        this.u_userType = u_userType;
    }

    public String getU_remark() {
        return u_remark;
    }

    public void setU_remark(String u_remark) {
        this.u_remark = u_remark;
    }

    public Date getU_startDate() {
        return u_startDate;
    }

    public void setU_startDate(Date u_startDate) {
        this.u_startDate = u_startDate;
    }
}
