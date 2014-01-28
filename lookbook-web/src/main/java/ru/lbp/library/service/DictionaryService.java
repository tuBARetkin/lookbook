package ru.lbp.library.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.lbp.library.dao.DictionaryClassDAO;
import ru.lbp.library.dao.DictionaryDataDAO;
import ru.lbp.library.domain.DictionaryClass;
import ru.lbp.library.domain.DictionaryData;
import ru.lbp.library.dto.DictionaryDataDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * User: NGorelov
 * Date: 03.09.12
 * Time: 21:00
 */
@Service
public class DictionaryService{
    @Autowired
    private DictionaryDataDAO dictionaryDataDAO;

    @Autowired
    private DictionaryClassDAO dictionaryClassDAO;

    @Autowired
    @Qualifier("dozerMapper")
    private Mapper mapper;

    @Transactional
    public List<DictionaryClass> getAllClasses(){
        return dictionaryClassDAO.getAllElements();
    }

    @Transactional
    public DictionaryClass getClassByName(String className){
        return dictionaryClassDAO.getElementByID(className);
    }

    @Transactional
    public List<DictionaryDataDTO> getAllEntitiesByDictionaryName(String dicName){
        return convertListToDTO(dictionaryDataDAO.getAllEntitiesByDictionaryName(dicName));
    }

    @Transactional
    public List<DictionaryDataDTO> getAllDisabledValues(String dataKey, String dicName){
        return convertListToDTO(dictionaryDataDAO.getAllDisabledValues(dataKey, dicName));
    }

    @Transactional
    public void createOrUpdateDictionaryItem(DictionaryDataDTO item){
        dictionaryDataDAO.saveOrUpdate(mapper.map(item, DictionaryData.class));
    }

    private List<DictionaryDataDTO> convertListToDTO(List<DictionaryData> dicList){
        List<DictionaryDataDTO> dicListDTO = new ArrayList<DictionaryDataDTO>();

        for(DictionaryData item : dicList){
            dicListDTO.add(mapper.map(item, DictionaryDataDTO.class));
        }

        return dicListDTO;
    }

    private List<DictionaryData> convertListToDomain(List<DictionaryDataDTO> dicListDTO){
        List<DictionaryData> dicList = new ArrayList<DictionaryData>();

        for(DictionaryDataDTO item : dicListDTO){
            dicList.add(mapper.map(item, DictionaryData.class));
        }

        return dicList;
    }

    private boolean checkDictionaryDataChangesDepth(DictionaryDataDTO item, int depth){
        if(depth > 0){
            checkDictionaryDataChangesDepth(convertListToDomain(item.getSubData()), 1, depth);
        }

        return mapper.map(item, DictionaryData.class).equals(dictionaryDataDAO.getElementByID(item.getDataKey()));
    }

    private boolean checkDictionaryDataChangesDepth(List<DictionaryData> listForCheckPar, int curDepth, int endDepth){
        List<DictionaryData> listForCheck = listForCheckPar;

        if(curDepth == endDepth){
            for(DictionaryData item : listForCheck){
                if(!item.equals(dictionaryDataDAO.getDetachedElementById(item.getDataKey()))){
                    return false;
                }
            }
        }
        else{
            for(DictionaryData item: listForCheck){
                listForCheck.addAll(item.getSubData());
            }
            checkDictionaryDataChangesDepth(listForCheck, ++curDepth, endDepth);
        }

        return true;
    }
}
