package com.garasipelosok.bsipracticeintent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMoveActivity;
    private Button btnMoveActivityWithData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity = (Button) findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        btnMoveActivityWithData = (Button) findViewById(R.id.btn_move_activity_data);
        btnMoveActivityWithData.setOnClickListener(this);
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
        }
    }
}