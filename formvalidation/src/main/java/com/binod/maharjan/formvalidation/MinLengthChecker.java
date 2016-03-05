package com.binod.maharjan.formvalidation;

/**
 * Created by binod on 3/4/16.
 */
public class MinLengthChecker extends Checker {

    int length;
    public MinLengthChecker(int length,String msg) {
        super(msg);
        this.length=length;
    }

    @Override
    public boolean isValid(String check) {

        if(check.length()<length)return false;
        return true;
    }
}
