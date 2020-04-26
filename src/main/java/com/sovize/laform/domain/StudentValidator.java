package com.sovize.laform.domain;


import java.util.ArrayList;

public final class StudentValidator extends StringValidator<StudentForm> {

    @Override
    public ArrayList<String> validate(StudentForm validable) {
        ArrayList<String> error = new ArrayList<>();
        if(fitsInRange(validable.getNames(), 1, 25)){
            error.add("E")
        }
        return error;
    }

}
