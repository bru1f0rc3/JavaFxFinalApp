package ru.demo.hotelapp.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.demo.hotelapp.util.HibernateSessionFactoryUtil;

import java.util.List;

public abstract class BaseDao<T> {
    private Class<T> clazz;

    public BaseDao(Class<T> clazz){this.clazz = clazz;}

    Session getCurrentSession(){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }

    public void deleteById(Long id){
        T entity = findOne(id);
        delete(entity);
    }

    public void delete(T entity){
        Session session = getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.remove(entity);
        tx1.commit();
        session.close();
    }

    public void update(T entity){
        Session session = getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.merge(entity);
        tx1.commit();
        session.close();
    }

    public void save(T entity){
        Session session = getCurrentSession();
        Transaction tx1 = session.beginTransaction();
        session.persist(entity);
        tx1.commit();
        session.close();
    }

    public T findOne(Long id){
        Session session = getCurrentSession();
        session.beginTransaction();
        T item = session.get(clazz,id);
        session.close();
        return item;
    }

    public List<T> findAll(){
        Session session = getCurrentSession();
        session.beginTransaction();
        List<T> items = (List<T>) session.createQuery("from " + clazz.getName()).list();
        session.close();
        return items;
    }
}
