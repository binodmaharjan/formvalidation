package com.binod.maharjan.formvalidation;

import com.binod.maharjan.formvalidation.Checker;

/**
 * Created by binod on 3/4/16.
 */
public class EmptyChecker extends Checker {
    public EmptyChecker(String msg) {
        super(msg);
    }

    @Override
    public boolean isValid(String check) {

        if(check.length()>0)return true;
        return false;
    }
}
