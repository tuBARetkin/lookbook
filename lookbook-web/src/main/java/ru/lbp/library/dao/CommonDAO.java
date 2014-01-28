package ru.lbp.library.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author gorelov-n
 */
public class CommonDAO
{
    @Autowired
    private SessionFactory sessionFactory;
    
    public void deleteElement(Object element){
        session().delete(element);
    }
    
    public void saveOrUpdate(Object element){
        session().saveOrUpdate(element);
    }

    protected Session session(){
        return sessionFactory.getCurrentSession();
    }
}
