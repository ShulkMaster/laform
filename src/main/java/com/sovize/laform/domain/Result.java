package com.sovize.laform.domain;

public class Result<T> {

    public final boolean failure;
    private final T data;

    public  Result(boolean failure, T data){
        this.failure = failure;
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
