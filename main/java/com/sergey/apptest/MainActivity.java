package com.sergey.apptest;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    EditText etNum1;
    EditText etNum2;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;

    Button btnClr;

    Button btnSetColor;
    RadioGroup radioColorGroup;

    TextView tvResult;

    Button getSecAct;

    String oper = "";

    float result = 0;
    float num1 = 0;
    float num2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // находим элементы
        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);

        btnClr = (Button) findViewById(R.id.buttonClear);

        radioColorGroup = (RadioGroup) findViewById(R.id.colorGroup);
        btnSetColor = (Button) findViewById(R.id.buttonSetColor);

        tvResult = (TextView) findViewById(R.id.tvResult);

        getSecAct = (Button) findViewById(R.id.getSecAct);

        // прописываем обработчик
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnClr.setOnClickListener(this);
        btnSetColor.setOnClickListener(this);
        getSecAct.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub

        // читаем EditText и заполняем переменные числами


        // определяем нажатую кнопку и выполняем соответствующую операцию
        // в oper пишем операцию, потом будем использовать в выводе
        switch (v.getId()) {
            case R.id.btnAdd:
                if (CheckFields()) {
                    oper = "+";
                    result = num1 + num2;
                    tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
                }
                else {
                    break;
                }
                break;
            case R.id.btnSub:
                if (CheckFields()) {
                    oper = "-";
                    result = num1 - num2;
                    tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
                }
                else {
                    break;
                }
                break;
            case R.id.btnMult:
                if (CheckFields()) {
                    oper = "*";
                    result = num1 * num2;
                    tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
                }
                else {
                    break;
                }
                break;
            case R.id.btnDiv:
                if (CheckFields()) {
                    oper = "/";
                    result = num1 / num2;
                    tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
                }
                else {
                    break;
                }
                break;
            case R.id.buttonSetColor:
                SetColor();
                break;
            case R.id.buttonClear:
                tvResult.setText("");
                break;
            case R.id.getSecAct:
                Intent intent = new Intent(this, SecondActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }

    }

    private void SetColor() {
        switch (radioColorGroup.getCheckedRadioButtonId()) {
            case R.id.colorRed:
                tvResult.setTextColor(Color.rgb(200, 0, 0));
                break;
            case R.id.colorGreen:
                tvResult.setTextColor(Color.rgb(0, 255, 0));
                break;
            case R.id.colorBlue:
                tvResult.setTextColor(Color.rgb(0, 0, 255));
                break;
            case R.id.colorWhite:
                tvResult.setTextColor(Color.rgb(255, 250, 250));
                break;
            default:
                break;
        }
    }

    private boolean CheckFields() {
        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return false;
        }
        else {
            num1 = Float.parseFloat(etNum1.getText().toString());
            num2 = Float.parseFloat(etNum2.getText().toString());
            return true;
        }
    }
}
