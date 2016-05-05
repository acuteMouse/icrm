package com.zy.base.baseDao.impl;

import com.zy.base.baseDao.IBaseDao;
import com.zy.util.Page;
import com.zy.util.SessionUitl;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created zy on 2016/3/19.
 * 类名：baseDaoImpl 实现IbaseDao借口
 * 作用：一些通用的数据操作方法,继承session工具类，实现IBaseDao接口
 */
@Repository("baseDao")
@Transactional
public class BaseDaoImpl<T> extends SessionUitl implements IBaseDao<T> {

    public void addEntity(T t) {
        getSeesion().save(t);
    }

    public void deleteEntity(T t) {
        getSeesion().delete(t);
    }

    public void updateEntity(T t) {
        getSeesion().update(t);
    }


    public List<T> findAll(T t) {
        Query query = getSeesion().createQuery("from " + t.getClass().getSimpleName());
        return query.list();
    }

    public void saveOrUpdateEntity(T t) {
        getSeesion().saveOrUpdate(t);
    }

    public T findById(long id, T t) {
        Query query = getSeesion().createQuery(("From " + t.getClass().getSimpleName() + " where id=:id"));
        query.setParameter("id", id);
        return (T) query.uniqueResult();
    }

    //    返回该对象对应表的记录总条数
    public Long getTotal(T t) {

        String sql = ("select count(*) from " + t.getClass().getSimpleName());
        Query query = getSeesion().createQuery(sql);
        return (Long) query.uniqueResult();
    }

    //    带分页的查询
    public List findAllByPAge(T t, Page p) {
        Query query = getSeesion().createQuery("from " + t.getClass().getSimpleName());
        query.setMaxResults(p.getRows());//设置一页多少行数据
        query.setFirstResult((p.getPage() - 1) * p.getRows());//mysql中分页从0开始
        return query.list();
    }

    /**
     * @param t
     * @param ids,要删除list
     */
    //批量删除
    public void deleteAll(T t, List<Integer> ids) {
        StringBuffer sql = new StringBuffer(128);
        sql.append("delete from " + t.getClass().getSimpleName());
        sql.append(" where id in (");
        if (ids.size() > 1) {

//        动态添加ID到sql中，最后一个单独添加
            for (int i = 0; i < ids.size() - 1; i++) {
                sql.append(ids.get(i) + ",");
            }
        }
        sql.append(ids.get(ids.size() - 1) + ")");
        Query query = getSeesion().createQuery(sql.toString());
        query.executeUpdate();
    }

}
