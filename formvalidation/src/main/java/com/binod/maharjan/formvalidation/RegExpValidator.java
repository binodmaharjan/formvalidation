package com.binod.maharjan.formvalidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by binod on 3/4/16.
 */
public class RegExpValidator extends Checker {
    Pattern pattern;

    public RegExpValidator(Pattern pattern,String msg) {
        super(msg);
        this.pattern=pattern;
    }

    @Override
    public boolean isValid(String check) {

        Matcher m=pattern.matcher(check);
       return m.matches();

    }
}
