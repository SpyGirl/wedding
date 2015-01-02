package com.wedding.dao.impls;

import com.wedding.dao.BaseDao;
import com.wedding.dao.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class BaseDaoImpl implements BaseDao {


    private Session session;

    public BaseDaoImpl() {
        session = HibernateUtil.getSession();
    }

    @Override
    public <T> List<T> getAll(Class<T> entity) {
        List<T> result = session.createCriteria(entity).list();
        return result;
    }

    @Override
    public <T> void deleteById(Class<T> entity, int id) {
        session.getTransaction().begin();

        T obj = findById(entity, id);
        session.delete(obj);

        session.getTransaction().commit();
    }

    @Override
    public <T> T findById(Class<T> entity, int id) {
        T result = (T) session.get(entity, id);
        return result;
    }

    @Override
    public <T> void merge(T obj) {
        session.merge(obj);
    }
}
