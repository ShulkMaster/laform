package com.sovize.laform.interfaces;

import java.util.ArrayList;

public interface IValidable {

    enum State {
        Valid,
        Unchecked,
        Invalid

    }

    State getStatus();

    ArrayList<String> validate();

    class Keys {
        public static final String Error = "errors";
    }

}
