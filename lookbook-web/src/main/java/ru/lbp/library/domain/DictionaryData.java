/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.lbp.library.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author NGorelov
 */
@Entity
@Table(name = "dictionary_data")
public class DictionaryData extends BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "data_key")
    private String dataKey;

    @Column(name = "value_ru")
    private String ruValue;

    @Column(name = "value_en")
    private String enValue;

    @Column(name = "dic_name")
    private String dicName;

    @JoinTable(name = "enable_data", joinColumns = {
            @JoinColumn(name = "main_data_key", referencedColumnName = "data_key")}, inverseJoinColumns = {
            @JoinColumn(name = "sub_data_key", referencedColumnName = "data_key")})
    @ManyToMany
    private List<DictionaryData> subData;

    public DictionaryData() {
    }

    public DictionaryData(String dataKey) {
        this.dataKey = dataKey;
    }

    public String getDataKey() {
        return dataKey;
    }

    public void setDataKey(String key) {
        this.dataKey = key;
    }

    public String getRuValue() {
        return ruValue;
    }

    public void setRuValue(String ruValue) {
        this.ruValue = ruValue;
    }

    public String getEnValue() {
        return enValue;
    }

    public void setEnValue(String enValue) {
        this.enValue = enValue;
    }

    public String getDicName() {
        return dicName;
    }

    public void setDicName(String dicName) {
        this.dicName = dicName;
    }

    public List<DictionaryData> getSubData() {
        return subData;
    }

    public List<DictionaryData> getSubData(String dicName) {
        List<DictionaryData> list = new ArrayList<DictionaryData>();
        for(DictionaryData item : list){
            if(item.getDicName().equals(dicName)){
                list.add(item);
            }
        }
        return list;
    }

    public void setSubData(List<DictionaryData> dictionaryDataList) {
        this.subData = dictionaryDataList;
    }

    @Override
    public String toString() {
        return "DictionaryData[ dataKey=" + dataKey + " ]";
    }
}
