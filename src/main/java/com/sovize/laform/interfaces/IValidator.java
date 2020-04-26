package com.sovize.laform.interfaces;

import org.springframework.web.servlet.ModelAndView;

public interface IValidator {

    ModelAndView createViewModel(IValidable student);

}
