package com.sovize.laform.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public abstract class Validator<T> {

    protected final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static class Keys{
        public static final String Error = "errors";
    }

    public Result<String> hasLength(@NotNull String challenger, @PositiveOrZero int challenge) {
        return new Result<>(
                challenger.length() != challenge,
                " El texto debe tener exactamente " + challenge + " caracteres"
        );
    }

    private boolean hasMinLength(@NotNull String challenger, @PositiveOrZero int challenge) {
        return challenger.length() < challenge;
    }

    private boolean hasMaxLength(@NotNull String challenger, @PositiveOrZero int challenge) {
        return !hasMinLength(challenger, challenge + 1);
    }

    public Result<String> fitsInRange(@NotNull String challenger, @PositiveOrZero int lowBoundary, @Positive int highBoundary) {
        if (hasMinLength(challenger, lowBoundary)) {
            return new Result<>(true, "El texto debe ser mayor a " + lowBoundary + " un character");
        } else if (hasMaxLength(challenger, highBoundary)) {
            return new Result<>(true, "El texto debe ser menor a " + highBoundary + " characteres");
        }
        return new Result<>(false, null);
    }

    public Result<String> isAfter(@NotNull String challengerDate, @NotNull String challengeDate) {
        try {
            boolean check = formatter.parse(challengerDate).after(formatter.parse(challengeDate));
            if (check) {
                return new Result<>(false, null);
            }
            return new Result<>(true, "La fecha debe ser despues de " + challengeDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Result<>(true, challengerDate + " Ni siquiera es una fecha 🤷‍♀️🤦‍♂️🤦‍♂️🤦‍♀️");
        }
    }

    public abstract Result<ArrayList<String>> validate(T validable);
}
