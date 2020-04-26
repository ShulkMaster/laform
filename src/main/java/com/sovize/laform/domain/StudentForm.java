package com.sovize.laform.domain;

import com.sovize.laform.interfaces.IValidable;

import java.util.ArrayList;

public final class StudentForm implements IValidable {

    private State state = State.Unchecked;
    private String names;
    private String lastNames;


    @Override
    public State getStatus() {
        return state;
    }

    @Override
    public ArrayList<String> validate() {

        return null;
    }


    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

}
