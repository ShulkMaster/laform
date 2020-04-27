package com.sovize.laform.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public abstract class Validator<T> {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static class Keys{
        public static final String Error = "errors";
    }

    private boolean hasMinLength(@NotNull String challenger, @PositiveOrZero int challenge) {
        return challenger.length() < challenge;
    }

    private boolean hasMaxLength(@NotNull String challenger, @PositiveOrZero int challenge) {
        return !hasMinLength(challenger, challenge + 1);
    }

    public Result<String> fitsInRange(@NotNull String challenger, @PositiveOrZero int lowBoundary, @Positive int highBoundary) {
        if (hasMinLength(challenger, lowBoundary)) {
            return new Result<>(true, "El texto debe ser mayor a " + lowBoundary + " characters");
        } else if (hasMaxLength(challenger, highBoundary)) {
            return new Result<>(true, "El texto debe ser menor a " + highBoundary + " characters");
        }
        return new Result<>(false, null);
    }

    public Result<String> IsAfter(@NotNull String challengerDate, @NotNull String challengeDate) {
        try {
            boolean check = formatter.parse(challengeDate).after(formatter.parse(challengerDate));
            if (check) {
                return new Result<>(false, null);
            }
            return new Result<>(true, "La fecha debe ser despues de " + challengeDate);
        } catch (ParseException e) {
            e.printStackTrace();
            return new Result<>(true, "Error inesperado");
        }
    }

    public abstract Result<ArrayList<String>> validate(T validable);
}
