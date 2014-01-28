/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lbp.library.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author gorelov-n
 */
public class ElementDAO<E> extends CommonDAO
{
    protected ElementDAO(Class<E> elementClass) {
        this.elementClass = elementClass;
    }

    public E getElementByID(Serializable elementId) {
        return (E) session().get(elementClass, elementId);
}

    public List<E> getAllElements() {
        return session().createCriteria(elementClass).list();
    }

    protected Class<E> getElementClass() {
        return elementClass;
    }

    private Class<E> elementClass;
}
