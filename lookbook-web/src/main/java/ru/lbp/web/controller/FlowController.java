package ru.lbp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.lbp.library.service.DictionaryService;
import ru.lbp.web.utils.Languages;

import javax.servlet.http.HttpServletRequest;

/**
 * User: NGorelov
 * Date: 01.10.12
 * Time: 14:38
 */
@Controller
@RequestMapping("/home/flow")
public class FlowController {
    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping("")
    public ModelAndView index(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("lookbook/home/flow");
        request.getSession().setAttribute("language", Languages.RU);
        return mav;
    }
}
