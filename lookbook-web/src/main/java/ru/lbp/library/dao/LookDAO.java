/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lbp.library.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import ru.lbp.library.domain.Look;

import java.util.Collection;

/**
 * @author gorelov-n
 */
@Repository
public class LookDAO extends DatedElementDAO<Look>
{
    public LookDAO() {
        super(Look.class);
    }

    public Collection<Look> getAllElements(boolean nonComplete) {
        Query query = null;
        if(nonComplete){
            query = session().createQuery("from Look where complete = :val").
                    setParameter("val", 0);
        }
        else{
            return getAllElements();
        }

        return query.list();
    }

    public Collection<Look> getLookByCountry(String country, boolean nonComplete) {
        Query query = null;
        if(nonComplete){
            query = session().createQuery("from Look where country = lower(:country) and complete = :flag").
                    setParameter("country", country).
                    setParameter("flag", 0);
        }
        else{
            query = session().createQuery("from Look where country = lower(:country)").
                    setParameter("country", country);
        }

        return query.list();
    }
}
