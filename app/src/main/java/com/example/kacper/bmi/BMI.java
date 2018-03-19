package com.example.kacper.bmi;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.*;
import java.text.DecimalFormat;

public class BMI extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
    }

    EditText waga =  (EditText) findViewById(R.id.editWeight);
    TextView res=(TextView) findViewById(R.id.result);
    String bmiTex=getString(R.string.bmiText);
    EditText wzrost =  (EditText) findViewById(R.id.editHeight);
    TextView desc=(TextView) findViewById(R.id.bmiDesc);
    String isZero=getString(R.string.isZero);
    String isEmpty=getString(R.string.emptyTextEdit);

    double weight=0;
    double height=0;
    double bmi=0;

    public void caluclateBtnFire(View view) {

        try{
            weight=Double.parseDouble(waga.getText().toString());
            height=Double.parseDouble(wzrost.getText().toString());
        }catch(NumberFormatException e){
            res.setText(isEmpty);
        }

        if(weight==0 |height==0){
            res.setText(isZero);
        }else {
            bmi = weight / (Math.pow(height / 100, 2));
            res.setText(bmiTex+" "+new DecimalFormat("##.##").format(bmi));
           if(bmi<18.5){
                desc.setText(R.string.bmiLow);}
            else if(bmi>=25){
                desc.setText(R.string.bmiHigh);
            }
            else if(bmi>18.5&&bmi<25){
                desc.setText(R.string.bmiNorm);
            }
        }

    }
}

