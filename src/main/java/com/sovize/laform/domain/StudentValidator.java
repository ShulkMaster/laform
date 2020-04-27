package com.sovize.laform.domain;

import java.util.ArrayList;

public final class StudentValidator extends Validator<StudentForm> {

    public StudentValidator() {
        formatter.setLenient(false);
    }

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

        Result<String> dateCheck = isAfter(validable.getDateOfBirth(), "2003-01-01");
        if (dateCheck.failure) {
            errors.add("Fecha de nacimiento: " + dateCheck.getData());
        }

        Result<String> placeCheck = fitsInRange(validable.getPlaceOfBirth(), 1, 25);
        if (placeCheck.failure) {
            errors.add("Lugar de nacimiento: " + placeCheck.getData());
        }

        Result<String> institutionCheck = fitsInRange(validable.getPlaceOfBirth(), 1, 100);
        if (institutionCheck.failure) {
            errors.add("Instituto o Colegio de procedencia: " + institutionCheck.getData());
        }

        if (errors.size() > 0) {
            return new Result<>(true, errors);
        }
        return new Result<>(false, errors);
    }
}
