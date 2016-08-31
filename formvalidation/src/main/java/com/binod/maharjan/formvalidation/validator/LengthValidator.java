package com.binod.maharjan.formvalidation.validator;


import com.binod.maharjan.formvalidation.base.Validator;
import com.binod.maharjan.formvalidation.base.ValidatorException;
import com.binod.maharjan.formvalidation.helper.Range;

public class LengthValidator extends Validator {

    final Range range;

    public LengthValidator(Range range, String errorMessage) {
        super(errorMessage);
        this.range = range;
    }


    @Override
    public boolean isValid(String value) throws ValidatorException {
        int length = value.length();
        if(range.includes(length)) {
            return true;
        }else{
            return false;
        }
    }
}
