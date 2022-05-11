package com.example.capstoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class register_self extends AppCompatActivity {

    Button bt_registration;
    ImageView imgbt_calender;
    DatePickerDialog datePickerDialog;
    String sDate;
    TextView tv_selfdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_self);

        bt_registration = findViewById(R.id.button6);
        imgbt_calender=findViewById(R.id.self_calender);
        tv_selfdate=findViewById(R.id.tv_selfdate);

        bt_registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register_self.this,Home.class);

                startActivity(intent);
            }
        });
        imgbt_calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int nYear = calendar.get(Calendar.YEAR);
                int nMonth = calendar.get(Calendar.MONTH);
                int nDay = calendar.get(Calendar.DAY_OF_MONTH);

                datePickerDialog = new DatePickerDialog(register_self.this,
                        new DatePickerDialog.OnDateSetListener(){
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day){
                                month+=1;
                                sDate=year+"/"+month+"/"+day;
                                tv_selfdate.setText(sDate);
                            }

                        },nYear,nMonth,nDay);
                datePickerDialog.show();
            }
        });
    }
}