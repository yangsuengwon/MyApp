package com.example.Capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {

    Button btBack;
    TextView tvCount, tvTotal, tvHm;
    String sStr;
    int nTotal =0, nCount =0, nYear =0;
    ArrayList<String> arrData =new ArrayList<>();
    HashMap<Integer,Integer> hmScreenchange =new HashMap<Integer,Integer>();
    HashMap<Integer,Integer> hmPartchange =new HashMap<Integer,Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        tvCount =findViewById(R.id.tv_Count);
        btBack =findViewById(R.id.bt_Back);
        tvTotal =findViewById(R.id.tv_Total);
        tvHm =findViewById(R.id.tv_Hm);

        arrData =getIntent().getStringArrayListExtra("arrData");
        nTotal =getIntent().getIntExtra("nTotal",0);
        nCount =getIntent().getIntExtra("nCount",0);
        sStr ="";
        hmScreenchange.clear();
        hmPartchange.clear();
        hmScreenchange =(HashMap<Integer, Integer>) getIntent().getSerializableExtra("hmScreenchange");
        hmPartchange =(HashMap<Integer, Integer>) getIntent().getSerializableExtra("hmPartchange");
        Collections.sort(arrData);
        for(int i = 0; i< arrData.size(); i++){
            sStr += arrData.get(i)+"년"+"\n";
            nYear =Integer.parseInt(arrData.get(i));
            sStr +="액정교체 "+ hmScreenchange.get(nYear)+"원\n";
            sStr +="부품교체 "+ hmPartchange.get(nYear)+"원\n";
            sStr +="----------------------------------\n";
        }
        tvCount.setText("A/S횟수는 "+ nCount +"건이며,");
        tvTotal.setText("총 비용은 "+ nTotal +"원입니다.");
        tvHm.setText(sStr);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}