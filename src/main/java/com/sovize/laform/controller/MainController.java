package com.sovize.laform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView vm = new ModelAndView();
        vm.addObject("hora", "vos come mierda vicho");
        vm.setViewName("index");
        return vm;
    }

    @RequestMapping("/ingresar")
    public ModelAndView submit(){
        return index();
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ModelAndView check(){
        return index();
    }

}
