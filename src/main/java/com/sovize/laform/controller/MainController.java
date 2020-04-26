package com.sovize.laform.controller;

import com.sovize.laform.domain.StudentForm;
import com.sovize.laform.interfaces.IValidable;
import com.sovize.laform.interfaces.IValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Component
public class MainController {

    private final IValidator<StudentForm> validator;

    @Autowired
    public MainController(IValidator<StudentForm> validator) {
        this.validator = validator;
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView vm = new ModelAndView();
        vm.setViewName("index");
        return vm;
    }

    @GetMapping("/ingresar")
    public ModelAndView submit() {
        return index();
    }

    @PostMapping(value = "/check")
    public ModelAndView check(StudentForm student) {
        ModelAndView vm = validator.createViewModel(student);
        vm.setViewName(student.getStatus().equals(IValidable.State.Valid) ? "valid" : "errors");
        return vm;
    }

}
