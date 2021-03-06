package com.sovize.laform.controller;

import com.sovize.laform.domain.Result;
import com.sovize.laform.domain.StudentForm;
import com.sovize.laform.domain.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@Component
public class MainController {

    private final Validator<StudentForm> validator;

    @Autowired
    public MainController(Validator<StudentForm> validator) {
        this.validator = validator;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView vm = new ModelAndView();
        vm.setViewName("index");
        vm.addObject("student", new StudentForm());
        return vm;
    }

    @GetMapping("/ingresar")
    public ModelAndView submit(StudentForm student) {
        return index();
    }

    @PostMapping(value = "/check")
    public ModelAndView check(StudentForm student) {
        ModelAndView vm = new ModelAndView();
        Result<ArrayList<String>> result = validator.validate(student);
        vm.addObject(Validator.Keys.Error, result.getData());
        vm.setViewName(result.failure ? "errors" : "valid");
        result.getData().forEach(System.out::println);
        return vm;
    }

}
