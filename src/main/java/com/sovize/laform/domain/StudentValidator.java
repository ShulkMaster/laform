package com.sovize.laform.domain;

import java.util.ArrayList;

public final class StudentValidator extends Validator<StudentForm> {

    public Result<ArrayList<String>> validate(StudentForm validable) {
        ArrayList<String> errors = new ArrayList<>();
        Result<String> nameCheck = fitsInRange(validable.getNames(), 1, 25);
        if (nameCheck.failure) {
            errors.add("Nombres: " + nameCheck.getData());
        }
        Result<String> lastNameCheck = fitsInRange(validable.getLastNames(), 1, 25);
        if (lastNameCheck.failure) {
            errors.add("Apellidos: " + lastNameCheck.getData());
        }
        if (errors.size() > 0) {
            return new Result<>(true, errors);
        }
        return new Result<>(false, errors);
    }
}
