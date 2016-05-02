package com.cgl.action;

import com.cgl.base.baseAction.BaseAction;
import com.cgl.model.CustomerType;
import com.cgl.model.Industry;
import com.cgl.util.Page;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cgl on 2016/4/02.
 * 类名：
 * 作用
 */
public class IndustryAction extends BaseAction implements ModelDriven<Industry> {
    private Industry industry = new Industry();
    private String ids;//删除用，支持批量

    public String getAll() {
        Page page = getPageInfo();
        List industryList = industryService.findAllByPage(new Industry(), page);
        long total = industryService.getTotal(new Industry());
        if (industryList != null && industryList.size() > 0) {
            dateMap = new HashMap<String, Object>();
//        构造datagrid需要的json格式 ｛“total”:xx,"rows"：[x,x,x]｝
            dateMap.put("total", total); //总数
            dateMap.put("rows", industryList);//具体数据
        }
        return Action.SUCCESS;
    }

    public String checkIndustyrIsExited() {
        if (industry != null && industry.getI_name() != null && !"".equals(industry.getI_name())) {
            boolean isExited = industryService.checkName(industry.getI_name());
            dateMap = new HashMap<String, Object>(); //初始化map
            if (isExited) {
                dateMap.put("msg", "已存在");
            } else {
                dateMap.put("msg", "可用");
            }
        }
        return Action.SUCCESS;
    }

    /**
     * 添加行业
     */
    public void add() {
        if (industry != null) {
            industryService.add(industry);
        }
    }

    /**
     * 删除行业
     *
     * @return
     */
    public void delete() {
        if (ids != null) {
            industryService.deleteAll(new Industry(), ids);
        }
    }

    /**
     * 修改行业名称
     *
     * @return
     */
    public void update() {
        if (industry != null) {
            industryService.update(industry);
        }
    }

    public Industry getModel() {
        return industry;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }
}
