package ru.lbp.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * User: NGorelov
 * Date: 11.10.12
 * Time: 19:29
 */
@Controller
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private LocaleResolver localeResolver;

    @RequestMapping("/wardrobe")
    public ModelAndView wardrobe(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("lookbook/diary");
        messageSource.getMessage("diary.wardrobe.tabTitle", null, new Locale("RU"));
        return mav;
    }
}
