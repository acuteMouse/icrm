package com.zy.model;

import javax.persistence.*;

/**
 * @autor cgl
 * @time 2016/5/5.
 * 作用:权限表
 */
@Entity(name = "t_power")
public class Power {
    private  long id;
    private  String url;//权限访问action路径
    private  String remark;//备注
    private  Role role;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
