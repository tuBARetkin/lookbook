/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lbp.library.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import java.util.Collection;
import java.util.Date;

/**
 * @author gorelov-n
 */
public class DatedElementDAO<E> extends ElementDAO<E>
{
    public DatedElementDAO(Class<E> elementClass) {
        super(elementClass);
    }

    public Collection<E> getElementBySourceFullDate(Date begin, Date end, boolean nonComplete) {
        Criteria criteria = session().createCriteria(getElementClass()).
                add(Restrictions.between("createDate", begin, end));
        if(nonComplete) {
            criteria.add(Restrictions.eq("complete", 0));
        }

        return criteria.list();
    }

    public Collection<E> getElementBySourceBeginDate(Date begin, boolean nonComplete) {
        Criteria criteria = session().createCriteria(getElementClass()).
                add(Restrictions.ge("createDate", begin));
        if(nonComplete) {
            criteria.add(Restrictions.eq("complete", 0));
        }

        return criteria.list();
    }

    public Collection<E> getElementBySourceEndDate(Date end, boolean nonComplete) {
        Criteria criteria = session().createCriteria(getElementClass()).
                add(Restrictions.le("createDate", end));
        if(nonComplete) {
            criteria.add(Restrictions.eq("complete", 0));
        }

        return criteria.list();
    }

    public Collection<E> getElementByAddFullDate(Date begin, Date end, boolean nonComplete) {
        Criteria criteria = session().createCriteria(getElementClass()).
                add(Restrictions.between("addDate", begin, end));
        if(nonComplete){
            criteria.add(Restrictions.eq("complete", 0));
        }

        return criteria.list();
    }

    public Collection<E> getElementByAddBeginDate(Date begin, boolean nonComplete) {
        Criteria criteria = session().createCriteria(getElementClass()).
                add(Restrictions.ge("addDate", begin));
        if(nonComplete){
            criteria.add(Restrictions.eq("complete", 0));
        }

        return criteria.list();
    }

    public Collection<E> getElementByAddEndDate(Date end, boolean nonComplete) {
        Criteria criteria = session().createCriteria(getElementClass()).
                add(Restrictions.le("addDate", end));
        if(nonComplete){
            criteria.add(Restrictions.eq("complete", 0));
        }
        return criteria.list();
    }
}
