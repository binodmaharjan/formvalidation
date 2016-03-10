package com.example.binod.validation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.binod.maharjan.formvalidation.FormV3;
import com.binod.maharjan.formvalidation.Form;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.editText)
    EditText editText;
    @Bind(R.id.editText2)
    EditText editText2;
    @Bind(R.id.button)
    Button button;
    @Bind(R.id.spinner)
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


// Array of choices
        String colors[] = {"Red","Blue","White","Yellow","Black", "Green","Purple","Orange","Grey"};

//

// Application of the Array to the Spinner
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,   android.R.layout.simple_spinner_item, colors);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        spinner.setAdapter(spinnerArrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isValidate();
//                editText.setError("Must be empty");
//                editText2.setError("nust not be empty");
            }
        });


    }

    public void isValidate() {
        Form form = new Form(this);
        form.checkEmpty(editText, "Must not be empty");
        form.checkPattern(editText, FormV3.TYPE_EMAIL, "Invalid email");
//        form.checkMinLength(editText, 8, "Length must be atleast 4");
        form.checkEmpty(editText2, "Must not be empty");
        form.checkMinLength((TextView) spinner.getSelectedView(), 5, "must be at least 5");


        Log.i("validate", "" + form.validate());

    }


}
