/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lbp.library.dao;

import org.springframework.stereotype.Repository;
import ru.lbp.library.domain.Thing;

import java.util.Collection;

/**
 *
 * @author gorelov-n
 */
@Repository
public class ThingDAO extends DatedElementDAO<Thing>
{
    public ThingDAO() {
        super(Thing.class);
    }

    public Collection<Thing> getAllElements(boolean nonComplete){
        return session().createCriteria(Thing.class).list();
    }
}
