package com.garasipelosok.bsipracticeintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveActivityWithObject extends AppCompatActivity {

    public static String EXTRA_PERSON = "extra_person";
    private TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvObject = (TextView) findViewById(R.id.tv_object_received);
        Person mPerson = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : "+mPerson.getName()+"\nEmail : "+mPerson.getEmail()+"\nAge : "+mPerson.getAge()+"\nLocation : "+mPerson.getCity();
        tvObject.setText(text);
    }
}