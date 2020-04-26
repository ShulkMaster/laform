package com.sovize.laform.domain;

import com.sovize.laform.interfaces.IValidable;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;

public final class StudentValidator extends StringValidator {

    public ModelAndView createViewModel(IValidable student){
        ArrayList<String> errors = student.validate();
        student.validate().forEach(System.out::println);
        ModelAndView vm = new ModelAndView();
        vm.addObject(IValidable.Keys.Error, errors);
        return vm;
    }
}
