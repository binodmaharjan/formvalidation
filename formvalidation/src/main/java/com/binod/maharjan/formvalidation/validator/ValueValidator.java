package com.binod.maharjan.formvalidation.validator;



import com.binod.maharjan.formvalidation.base.Validator;
import com.binod.maharjan.formvalidation.base.ValidatorException;
import com.binod.maharjan.formvalidation.helper.Range;

import java.math.BigDecimal;
import java.util.regex.Pattern;


public class ValueValidator extends Validator {

    final Range range;

    public ValueValidator(Range range, String errorMessage) {
        super(errorMessage);
        this.range = range;
    }

    public static boolean isNumberFormat(String text) {
        return Pattern.compile("^([1-9]|(0(\\.|$)))").matcher(text).find();
    }

    @Override
    public boolean isValid(String valueText) throws ValidatorException {
        if (!isNumberFormat(valueText)) {
            return false;
        }

        BigDecimal value;
        try {
            value = new BigDecimal(valueText);
        } catch (Exception e) {
            return false;
        }

        if (value.scale() == 0) {
            try {
                return range.includes(value.intValueExact());
            } catch (Exception e) {
            }
            try {
                return range.includes(value.longValueExact());
            } catch (Exception e) {
            }
        }
        try {
            return range.includes(value.floatValue());
        } catch (Exception e) {
        }
        try {
            return range.includes(value.doubleValue());
        } catch (Exception e) {
        }

        return false;
    }
}
