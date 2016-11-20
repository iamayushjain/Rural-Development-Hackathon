package com.ayush.ruraldeveloment;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayush on 20/11/16.
 */

public class Register extends Activity {
    EditText editText;
    Button button,button1;
    Spinner spinner2;

    //String states={"Uttar Pradesh",""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        init();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef2 = database.getReference("vc").push();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef2.setValue(editText.getText().toString() + " :: " + String.valueOf(spinner2.getSelectedItem()));
                Intent intent = new Intent(Register.this, SmsReading.class);
                startActivity(intent);

//                SharedPreferences.Editor editor = sp.edit();
//                editor.putString("ads_",  + "");
//                editor.commit();


                //myRef2.push();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, SmsReading.class);
                startActivity(intent);

            }
        });



    }

    void init() {
        editText = (EditText) findViewById(R.id.number);
        button = (Button) findViewById(R.id.button);
        button1 = (Button) findViewById(R.id.button1);
        spinner2 = (Spinner) findViewById(R.id.spinner1);
        String[] states = {"West Bengal", "Haryana", "Andhra Pradesh", "Uttar Pradesh", "Maharashtra", "Punjab", "Karnataka", "Telangana", "Tamil Nadu"};
        List<String> list = Arrays.asList(states);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }
}

