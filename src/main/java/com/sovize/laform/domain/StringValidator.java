package com.sovize.laform.domain;

import com.sovize.laform.interfaces.IValidable;
import com.sovize.laform.interfaces.IValidator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class StringValidator <T extends IValidable> implements IValidator<T> {

    private final SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

    public boolean hasMinLength(@NotNull String challenger, @PositiveOrZero int challenge) {
        return challenger.length() >= challenge;
    }

    public boolean hasMaxLength(@NotNull String challenger, @PositiveOrZero int challenge) {
        return !hasMinLength(challenger, challenge + 1);
    }

    public boolean fitsInRange(@NotNull String challenger, @PositiveOrZero int lowBoundary, @Positive int highBoundary) {
        return hasMinLength(challenger, lowBoundary) && hasMaxLength(challenger, highBoundary);
    }

    public boolean IsAfter(@NotNull String challengerDate, @NotNull Date challenge) {
        try {
            return challenge.after(formatter.parse(challengerDate));
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
}
