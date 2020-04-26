package com.sovize.laform.controller;

import com.sovize.laform.helper.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Component
public class MainController {

    private final StudentValidator validator;

    @Autowired
    public MainController(StudentValidator validator) {
        this.validator = validator;
    }

    @RequestMapping("/")
    public ModelAndView index() {
        ModelAndView vm = new ModelAndView();
        vm.setViewName("index");
        return vm;
    }

    @RequestMapping("/ingresar")
    public ModelAndView submit() {
        return index();
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ModelAndView check() {
        ModelAndView vm = new ModelAndView();
        vm.setViewName("valid");
        validator.validate();
        return vm;
    }

}
