package com.binod.maharjan.formvalidation;

import android.content.Context;
import android.util.Patterns;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by binod on 3/4/16.
 */
public class Form {

    public static final Pattern TYPE_EMAIL= Patterns.EMAIL_ADDRESS;
    public static final String TELEPHONE = "(^\\+\\d+)?[0-9\\s()-]*";



    Context mContext;
    List<Checker>c;
    HashMap<EditText,List<Checker>>fields;

    public Form(Context mContext) {
        this.mContext = mContext;

        fields=new HashMap<>();
    }

    public void checkEmpty(EditText editText,String errorMsg){
        Checker checker=new EmptyChecker(errorMsg);
        addFields(editText,checker);
    }

    public void checkMinLength(EditText editText,int length,String errorMsg){
        MinLengthChecker checker=new MinLengthChecker(length,errorMsg);
        addFields(editText,checker);
    }

    public void checkPattern(EditText editText,String regex,String errorMsg){
        Pattern p=Pattern.compile(regex);
        RegExpValidator validator=new RegExpValidator(p,errorMsg);
        addFields(editText,validator);

    }

    public void checkPattern(EditText editText,Pattern p,String errorMsg){

        RegExpValidator validator=new RegExpValidator(p,errorMsg);

        addFields(editText,validator);

    }

    private void addFields(EditText editText,Checker checker){

        if(fields.containsKey(editText)){
           c=fields.get(editText);

        }else{
            c=new ArrayList<>();
            fields.put(editText, c);
        }
        c.add(checker);


    }

    public boolean validate(){
        boolean isValid=true;

        // Get a set of the entries
        Set set = fields.entrySet();
        // Get an iterator
        Iterator i = set.iterator();
        // Display elements
        while(i.hasNext()) {
            Map.Entry entry = (Map.Entry)i.next();
            System.out.print(entry.getKey() + ": ");
            System.out.println(entry.getValue());

            EditText et=(EditText)entry.getKey();
            List<Checker>c=(List<Checker>)entry.getValue();
            isValid=isValid && this.isFormValid(et, c);
        }

        return isValid;
    }

    private boolean isFormValid(EditText editText,List<Checker>c){
        for(Checker check: c){
            if(!check.isValid(editText.getText().toString().trim())){
                editText.setError(check.getMessage());
                return false;
            }
        }

        editText.setError(null);
        return true;
    }
}
