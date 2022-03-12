package com.garasipelosok.bsipracticeintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class MoveActivityForResult extends AppCompatActivity implements View.OnClickListener{

    private Button btnChoose;
    private RadioGroup rgNumber;
//    private RadioGroup rgCountry;
    public static String EXTRA_SELECTED_VALUE = "extra_selected_value";
//    pemberian RESULT_CODE bebas, disesuaikan kebutuhan pengembangan
    public static int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_for_result);

        btnChoose = (Button) findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
        rgNumber = (RadioGroup) findViewById(R.id.rg_number);
    }

    @Override
    public void onClick(View v){
        if (v.getId() == R.id.btn_choose){
            if (rgNumber.getCheckedRadioButtonId()!=0){
                int value = 0;
                switch (rgNumber.getCheckedRadioButtonId()){
                    case R.id.rb_09:
                        value = 9;
                        break;
                    case R.id.rb_10:
                        value = 10;
                        break;
                    case R.id.rb_25:
                        value = 25;
                        break;
                    case R.id.rb_77:
                        value = 77;
                        break;
                }
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value);
                setResult(RESULT_CODE,resultIntent);
                finish();
            }
        }
    }
}