package ru.lbp.library.dao;

import org.springframework.stereotype.Repository;
import ru.lbp.library.domain.DictionaryClass;

/**
 * User: NGorelov
 * Date: 25.09.12
 * Time: 4:25
 */
@Repository
public class DictionaryClassDAO extends ElementDAO<DictionaryClass> {
    public DictionaryClassDAO(){
        super(DictionaryClass.class);
    }
}
