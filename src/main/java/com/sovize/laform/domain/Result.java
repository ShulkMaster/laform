package com.sovize.laform.domain;

public class Result<T> {

    public final boolean success;
    public T Data;

    public  Result(boolean success){
        this.success = success;
    }

    public T getData() {
        return Data;
    }

    public void setData(T data) {
        Data = data;
    }
}
