package com.binod.maharjan.formvalidation.helper;


import android.util.Patterns;

import java.util.regex.Pattern;

public class RegexTemplate {

    public static final Pattern NOT_EMPTY_PATTERN = Pattern.compile("(?m)^\\s*\\S+[\\s\\S]*$");
    public static final Pattern PHONE_PATTERN = Patterns.PHONE;
    public static final Pattern EMAIL_PATTERN = Patterns.EMAIL_ADDRESS;
    public static final Pattern HEX_PATTERN = Pattern.compile("^(#|)[0-9A-Fa-f]+$");
    public static final Pattern IP_ADDRESS_PATTERN = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." + "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
    public static final String ZIP_PATTERN="^\\d{5}(?:[-\\s]\\d{4})?$";
    private RegexTemplate() {
        throw new UnsupportedOperationException();
    }
}
