package com.example.Capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    Button btEnter;
    Spinner spinner;
    EditText edYear, edPrice;
    int nChk, nPrice, nScreenchangetotal = 0, nPartchangetotal = 0, nCount = 0, nTotal = 0, nYear=0;
    String sYear, sSelect = "";
    ArrayList<String> arrData = new ArrayList<>();
    HashMap<Integer, Integer> hmScreenchange = new HashMap<Integer, Integer>();
    HashMap<Integer, Integer> hmPartchange = new HashMap<Integer, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btEnter = findViewById(R.id.bt_Enter);
        edYear = findViewById(R.id.ed_Year);
        edPrice = findViewById(R.id.ed_Price);
        spinner = findViewById(R.id.spinner);

        btEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nIntnet = new Intent(getApplicationContext(), MainActivity2.class);
                try{
                    sYear = edYear.getText().toString();
                    nYear = Integer.parseInt(sYear);
                    nPrice = Integer.parseInt(edPrice.getText().toString());
                    nTotal += nPrice;
                    if (!arrData.contains(sYear))
                        arrData.add(sYear);
                    nIntnet.putExtra("arrData", arrData);
                    nIntnet.putExtra("nTotal", nTotal);
                    nIntnet.putExtra("hmScreenchange", hmScreenchange);
                    nIntnet.putExtra("hmPartchange", hmPartchange);

                    if(nChk ==0){
                        if (hmScreenchange.containsKey(nYear)) {
                            nScreenchangetotal = 0;
                            nScreenchangetotal = hmScreenchange.get(nYear) + nPrice;
                            hmScreenchange.remove(nYear);
                            hmScreenchange.put(nYear, nScreenchangetotal);
                        } else {
                            hmScreenchange.put(nYear, nPrice);
                            hmPartchange.put(nYear, 0);
                        }
                    }
                    if(nChk ==1){
                        if(hmPartchange.containsKey(nYear)){
                            nPartchangetotal =0;
                            nPartchangetotal = hmPartchange.get(nYear) + nPrice;
                            hmPartchange.remove(nYear);
                            hmPartchange.put(nYear, nPartchangetotal);
                        }
                        else{
                            hmPartchange.put(nYear, nPrice);
                            hmScreenchange.put(nYear,0);
                        }
                    }
                    nCount += 1;
                    nIntnet.putExtra("nCount", nCount);
                    startActivity(nIntnet);

                }catch(Exception e){
                    edPrice.setText("");
                    edYear.setText("");
                    edYear.setHint("년도");
                    edPrice.setHint("수리금액");

                }


            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                sSelect = spinner.getSelectedItem().toString();
                if (sSelect.equals("액정교체")) {
                    nChk = 0;

                } else {
                    nChk = 1;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    }

