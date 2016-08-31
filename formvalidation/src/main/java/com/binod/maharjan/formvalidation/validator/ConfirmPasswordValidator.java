package com.binod.maharjan.formvalidation.validator;


import com.binod.maharjan.formvalidation.base.Validator;
import com.binod.maharjan.formvalidation.base.ValidatorException;

public class ConfirmPasswordValidator extends Validator {

    final String firstPassword;


    public ConfirmPasswordValidator(String firstPassword, String errorMessage) {
        super(errorMessage);
        this.firstPassword = firstPassword;

    }

    @Override
    public boolean isValid(String value) throws ValidatorException {
        if(firstPassword.equals(value)) {
            return true;
        }else {
            return false;
        }
    }
    

}
