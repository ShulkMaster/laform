package com.sovize.laform.domain;


import com.sovize.laform.interfaces.IValidable;


public final class StudentForm implements IValidable {

    private State state = IValidable.State.Unchecked;
    private String names;
    private String lastNames;


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

    @Override
    public State getStatus() {
        return state;
    }


}
