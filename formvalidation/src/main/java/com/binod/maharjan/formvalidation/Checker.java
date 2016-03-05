package com.binod.maharjan.formvalidation;

/**
 * Created by binod on 3/4/16.
 */
public abstract class Checker {

    String msg;

    public Checker(String msg) {
        this.msg = msg;
    }
    public  abstract boolean isValid(String check);

    public String getMessage() {
        return msg;
    }
}
