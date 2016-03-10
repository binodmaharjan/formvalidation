package com.binod.maharjan.formvalidation;

/**
 * Created by binod on 3/8/16.
 */

import android.content.Context;
import android.util.Patterns;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by binod on 3/4/16.
 */
public class Form {

    public static final Pattern TYPE_EMAIL= Patterns.EMAIL_ADDRESS;
    public static final String TELEPHONE = "(^\\+\\d+)?[0-9\\s()-]*";

    Context mContext;

    HashMap<TextView,List<Checker>> fields;

    public Form(Context mContext) {
        this.mContext = mContext;

        fields=new HashMap<>();
    }

    public void checkEmpty(TextView editText,String errorMsg){
        Checker checker=new EmptyChecker(errorMsg);
        addFields(editText,checker);
    }

    public void checkMinLength(TextView editText,int length,String errorMsg){
        MinLengthChecker checker=new MinLengthChecker(length,errorMsg);
        addFields(editText,checker);
    }

    public void checkPattern(TextView editText,String regex,String errorMsg){
        Pattern p=Pattern.compile(regex);
        RegExpValidator validator=new RegExpValidator(p,errorMsg);
        addFields(editText,validator);

    }

    public void checkPattern(TextView editText,Pattern p,String errorMsg){
        RegExpValidator validator=new RegExpValidator(p,errorMsg);
        addFields(editText,validator);
    }

    public boolean validate() {
        boolean formValid = true;
        for (Map.Entry<TextView, List<Checker>> entry : fields.entrySet()) {
            TextView editText = entry.getKey();
            List<Checker> validators = entry.getValue();
            formValid = formValid & validateField(editText, validators);
        }

        return formValid;
    }



    private boolean validateField(TextView editText, List<Checker> validators) {
        for (Checker validator : validators) {
            if (!validator.isValid(editText.getText().toString().trim())) {
                editText.setError(validator.getMessage());
                return false;
            }
        }
        editText.setError(null);
        return true;
    }

    private void addFields(TextView editText, Checker checker) {
        List<Checker> c;
        if (fields.containsKey(editText)) {
            c = fields.get(editText);
        } else {
            c = new ArrayList<>();
            fields.put(editText, c);
        }
        c.add(checker);
    }
}
