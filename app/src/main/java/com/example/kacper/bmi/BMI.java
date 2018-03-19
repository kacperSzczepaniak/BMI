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

    private EditText weightEditText =  (EditText) findViewById(R.id.editWeight);
    private TextView result=(TextView) findViewById(R.id.result);
    private String bmiText=getString(R.string.bmiText);
    private EditText heightEditText=  (EditText) findViewById(R.id.editHeight);
    private TextView description=(TextView) findViewById(R.id.bmiDesc);
    private String isZero=getString(R.string.isZero);
    private String isEmpty=getString(R.string.emptyTextEdit);

    private double weight=0;
    private double height=0;
    private double bmi=0;

    public void caluclateBtnFire(View view) {

        try{
            weight=Double.parseDouble(weightEditText.getText().toString());
            height=Double.parseDouble(heightEditText.getText().toString());
        }catch(NumberFormatException e){
            result.setText(isEmpty);
        }

        if(weight==0 |height==0){
            result.setText(isZero);
        }else {
            bmi = weight / (Math.pow(height / 100, 2));
            result.setText(bmiText+" "+new DecimalFormat("##.##").format(bmi));
           if(bmi<18.5){
               description.setText(R.string.bmiLow);}
            else if(bmi>=25){
               description.setText(R.string.bmiHigh);
            }
            else if(bmi>18.5&&bmi<25){
               description.setText(R.string.bmiNorm);
            }
        }

    }
}

