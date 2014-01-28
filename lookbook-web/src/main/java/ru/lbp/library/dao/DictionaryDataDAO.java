package ru.lbp.library.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import ru.lbp.library.domain.DictionaryData;

import java.util.ArrayList;
import java.util.List;

/**
 * User: NGorelov
 * Date: 03.09.12
 * Time: 21:02
 */
@Repository
public class DictionaryDataDAO extends ElementDAO<DictionaryData> {

    public DictionaryDataDAO(){
        super(DictionaryData.class);
    }

    public List<DictionaryData> getAllEntitiesByDictionaryName(String dicName){
        return session().createCriteria(DictionaryData.class)
                .add(Restrictions.eq("dicName", dicName))
                .list();
    }

    public DictionaryData getDetachedElementById(String dataKey){
        DictionaryData item = getElementByID(dataKey);
        session().evict(item);
        return item;
    }

    public List<DictionaryData> getAllDisabledValues(String dataKey, String dicName){
        //todo изменить на один запрос и посмотреть как будет быстрее
        DictionaryData dicData = (DictionaryData)session().createCriteria(DictionaryData.class)
                .add(Restrictions.eq("dataKey", dataKey))
                .uniqueResult();

        List<String> keys = new ArrayList<String>();
        for(DictionaryData item : dicData.getSubData()){
            keys.add(item.getDataKey());
        }

        Criteria criteria = session().createCriteria(DictionaryData.class)
                .add(Restrictions.eq("dicName", dicName));
        if(keys.size() > 0){
            criteria.add(Restrictions.not(Restrictions.in("dataKey", keys)));
        }

        return criteria.list();
    }
}
