package com.sovize.laform.interfaces;

import java.util.ArrayList;

public interface IValidator<T extends IValidable> {
    ArrayList<String> validate(T validable);
}
