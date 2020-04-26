package com.sovize.laform.interfaces;

import com.sovize.laform.domain.StringValidator;

import java.util.ArrayList;

public interface IValidable {

    enum State {
        Valid,
        Unchecked,
        Invalid
    }

    class Keys {
        public static final String Error = "errors";
    }

    State getStatus();

    ArrayList<String> validate(StringValidator validator);

}
