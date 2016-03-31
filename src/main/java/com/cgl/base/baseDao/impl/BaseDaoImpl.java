package com.cgl.base.baseDao.impl;

import com.cgl.base.baseDao.IBaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created cgl on 2016/3/19.
 * 类名：baseDaoImpl 实现IbaseDao借口
 * 作用：一些通用的数据操作方法
 */
@Repository("baseDao")
@Transactional
public class BaseDaoImpl implements IBaseDao {

    public void addEntity(Object o) {
        getSeesion().save(o);
    }

    public void deleteEntity(Object o) {
        getSeesion().delete(o);
    }

    public void updateEntity(Object o) {
        getSeesion().update(o);
    }


    public List findAll(Object o) {
        StringBuffer hql = new StringBuffer(512);
        hql.append("from " + o.getClass().getSimpleName());
        Query query = getSeesion().createQuery(hql.toString());
        return query.list();
    }

    public void saveOrUpdateEntity(Object o) {
        getSeesion().saveOrUpdate(o);
    }

    public Object findById(long id, Object o) {
        StringBuffer sql = new StringBuffer(512);
        sql.append("From " + o.getClass().getSimpleName() + " where id=:id");
        Query query = getSeesion().createQuery(sql.toString());
        query.setParameter("id", id);
        return query.uniqueResult();
    }

    //    返回该对象对应表的记录总条数
    public Long getTotal(Object o) {
       
        String sql=("select count(*) from " + o.getClass().getSimpleName());
        Query query = getSeesion().createQuery(sql);
        return (Long) query.uniqueResult();
    }


    @Resource//注入sessionfactory
    protected SessionFactory sessionFactory;

    public Session getSeesion() { //返回session，由spring管理
        return sessionFactory.getCurrentSession();
    }
}
