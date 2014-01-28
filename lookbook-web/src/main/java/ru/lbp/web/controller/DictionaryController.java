package ru.lbp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.lbp.library.domain.DictionaryClass;
import ru.lbp.library.domain.DictionaryData;
import ru.lbp.library.dto.DictionaryDataDTO;
import ru.lbp.library.service.DictionaryService;

import java.util.Arrays;
import java.util.List;

/**
 * Created by tub.
 * User: tub
 * Date: 07.08.12
 * Time: 0:25
 */
@Controller
@RequestMapping("/dictionary")
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping("/edit")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("lookbook/dictionary/edit");
        return mav;
    }

    @RequestMapping("/combine")
    public ModelAndView combine(){
        ModelAndView mav = new ModelAndView("lookbook/dictionary/combine");
        return mav;
    }

    @RequestMapping(value = "/getAllClasses", method = RequestMethod.GET)
    @ResponseBody
    public List<DictionaryClass> getAllClasses(){
        return dictionaryService.getAllClasses();
    }

    @RequestMapping(value = "/list/{dicName}", method = RequestMethod.GET)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<DictionaryDataDTO> getAllEntitiesByDictionaryName(@PathVariable String dicName){
        return dictionaryService.getAllEntitiesByDictionaryName(dicName);
    }

    @RequestMapping(value = "/listDisabled/{dataKey}/{dicName}", method = RequestMethod.GET)
    @ResponseBody
    public List<DictionaryDataDTO> getAllDisabledValues(@PathVariable String dataKey, @PathVariable String dicName){
        return dictionaryService.getAllDisabledValues(dataKey, dicName);
    }

    @RequestMapping(value = "/saveAll/{dicName}", method = RequestMethod.POST)
    public void updateAllItems(@RequestBody DictionaryData[] data, @PathVariable String dicName){
        List<DictionaryData> dicList = Arrays.asList(data);
    }

    @RequestMapping(value = "/save/{dicName}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void createOrUpdateDictionaryItem(@RequestBody DictionaryDataDTO item, @PathVariable String dicName){
        dictionaryService.createOrUpdateDictionaryItem(item);
    }
}
