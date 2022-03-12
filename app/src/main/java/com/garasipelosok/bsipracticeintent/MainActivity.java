package com.garasipelosok.bsipracticeintent;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMoveActivity;
    private Button btnMoveActivityWithData;
    private Button btnMoveActivityWithObject;
    private Button btnDialPhone;
    private Button btnMoveForResult;
    private TextView tvResult;
    //    pemberian REQUEST_CODE bebas, disesuaikan kebutuhan pengembangan
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = (Button) findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        btnMoveActivityWithData = (Button) findViewById(R.id.btn_move_activity_data);
        btnMoveActivityWithData.setOnClickListener(this);

        btnMoveActivityWithObject = (Button) findViewById(R.id.btn_move_activity_object);
        btnMoveActivityWithObject.setOnClickListener(this);

        btnDialPhone = (Button) findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);

        btnMoveForResult = (Button) findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);
        tvResult = (TextView) findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_activity:
                Intent moveintent = new Intent(MainActivity.this,MoveActivity.class);
                startActivity(moveintent);
                break;
            case R.id.btn_move_activity_data:
                Intent moveIntentWithData = new Intent(MainActivity.this,MoveActivityWithData.class);
                moveIntentWithData.putExtra(MoveActivityWithData.EXTRA_NAME,"Muhammad Umar Ridwan");
                moveIntentWithData.putExtra(MoveActivityWithData.EXTRA_AGE,23);
                startActivity(moveIntentWithData);
                break;
            case R.id.btn_move_activity_object:
                Person mPerson = new Person();
                mPerson.setName("Muhammad Umar Ridwan");
                mPerson.setAge(23);
                mPerson.setEmail("mur@site.test");
                mPerson.setCity("Tegal");
                Intent moveActivityWithObject = new Intent(MainActivity.this,MoveActivityWithObject.class);
                moveActivityWithObject.putExtra(MoveActivityWithObject.EXTRA_PERSON,mPerson);
                startActivity(moveActivityWithObject);
                break;
            case R.id.btn_dial_number:
                String phoneNumber = "082110262110";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this,MoveActivityForResult.class);
                startActivityForResult(moveForResultIntent,REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveActivityForResult.RESULT_CODE) {
                int selectedValue = data.getIntExtra(MoveActivityForResult.EXTRA_SELECTED_VALUE,0);
                tvResult.setText("Hasil : "+selectedValue);
            }
        }
    }
}