package com.zy.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;
import com.zy.base.baseAction.BaseAction;
import com.zy.model.Power;
import com.zy.service.IPowerService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @autor cgl
 * @time 2016/5/6.
 * 作用: 权限操作控制器
 */
@Controller
public class PowerAction extends BaseAction implements ModelDriven<Power> {
    private Power power = new Power();
    private String id;

    @Resource
    private IPowerService powerService;
    /**
     * 查询所有
     *
     * @return
     */
    public String getAll() {
//        Page p = getPageInfo();//分页
        List powerList = powerService.findAll(new Power());
        long total = powerService.getTotal(new Power());
        dateMap = new HashMap<String, Object>();
        if (powerList != null && powerList.size() > 0) {
//        构造datagrid需要的json格式 ｛“total”:xx,"rows"：[x,x,x]｝
//            dateMap.put("total", total); //总数
            dateMap.put("powers", powerList);//具体数据
            ActionContext.getContext().put("list",powerList);
        }
        return Action.SUCCESS;
    }

    /**
     * 添加用户，权限
     */
    public void add() {
        if (power != null) {
            powerService.add(power);
        }
    }

    /**
     * 删除角色
     *
     * @return
     */
   /* public void delete() {
        if(power!=null&&power.getId()!=0){
            powerService.deleteById(power,power.getId());
        }

    }*/

    /**
     * 修改角色
     *
     * @return
     */
    public void update() {
        if (power != null) {
            powerService.update(power);
        }
    }

    public Power getModel() {
        return power;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
