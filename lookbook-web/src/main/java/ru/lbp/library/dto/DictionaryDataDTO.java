package ru.lbp.library.dto;

import javax.persistence.*;
import java.util.List;

/**
 * User: NGorelov
 * Date: 29.09.12
 * Time: 20:59
 */
public class DictionaryDataDTO {
    private String dataKey;
    private String ruValue;
    private String enValue;
    private String dicName;
    private List<DictionaryDataDTO> subData;

    public String getDataKey() {
        return dataKey;
    }

    public void setDataKey(String dataKey) {
        this.dataKey = dataKey;
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

    public List<DictionaryDataDTO> getSubData() {
        return subData;
    }

    public void setSubData(List<DictionaryDataDTO> subData) {
        this.subData = subData;
    }
}
