package com.sergey.apptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity implements OnClickListener {

    float cFir = 0;

    String SelectItemFrom;
    String SelectItemTo;
    Spinner spinnerFrom;
    Spinner spinnerTo;


    Button btnConvert;
    EditText cFrom;
    TextView cResult;
    String[] data = {"Celsius", "Fahrenheit", "Kelvin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFrom = (Spinner) findViewById(R.id.spinFrom);
        spinnerFrom.setAdapter(adapter);
        spinnerTo = (Spinner) findViewById(R.id.spinTo);
        spinnerTo.setAdapter(adapter);

        cFrom = (EditText) findViewById(R.id.etFirst);
        cResult = (TextView) findViewById(R.id.etSecond);

        btnConvert = (Button) findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (!CheckFields()) {
            return;
        }
        SelectItemFrom = spinnerFrom.getSelectedItem().toString();
        SelectItemTo = spinnerTo.getSelectedItem().toString();
        /*if (SelectItemFrom.equals(SelectItemTo)) {
            cResult.setText(cFrom.getText().toString());
            return;
        }*/
        Convert(SelectItemFrom, SelectItemTo);
    }

    private boolean CheckFields() {
        if (TextUtils.isEmpty(cFrom.getText().toString())) {
            return false;
        }
        else {
            return true;
        }
    }

    private void Convert(String typeFrom, String typeTo) {
        cFir = Float.parseFloat(cFrom.getText().toString());
        switch (typeFrom) {
            case "Celsius":
                if (cFir >= (float)-273.15) {
                    cResult.setText(""+CelsiusTo(typeTo));
                }
                else {
                    cResult.setText("Incorrect input");
                }
                break;
            case "Kelvin":
                if (cFir >= 0) {
                    cResult.setText(""+KelvinTo(typeTo));
                }
                else {
                    cResult.setText("Incorrect input");
                }
                break;
            case "Fahrenheit":
                if (cFir >= (float)-459.66998) {
                    cResult.setText(""+FahrenheitTo(typeTo));
                }
                else {
                    cResult.setText("Incorrect input");
                }
                break;
            default:
                break;
        }
    }

    private float CelsiusTo(String typeTo) {
        float result = 0;
        switch (typeTo) {
            case "Celsius":
                result = Float.parseFloat(cFrom.getText().toString());
                break;
            case "Kelvin":
                result = cFir + (float)273.15;
                break;
            case "Fahrenheit":
                result = cFir * (float)1.8 + 32;
                break;
            default:
                break;
        }
        return result;
    }

    private float KelvinTo(String typeTo) {
        float result = 0;
        switch (typeTo) {
            case "Kelvin":
                result = Float.parseFloat(cFrom.getText().toString());
                break;
            case "Celsius":
                result = cFir - (float)273.15;
                break;
            case "Fahrenheit":
                result = (cFir - (float)273.15) * (float)1.8 + 32;
                break;
            default:
                break;
        }
        return result;
    }

    private float FahrenheitTo(String typeTo) {
        float result = 0;
        switch (typeTo) {
            case "Fahrenheit":
                result = Float.parseFloat(cFrom.getText().toString());
                break;
            case "Celsius":
                result = (float) (cFir - 32) / (float)1.8;
                break;
            case "Kelvin":
                result = (float) (cFir - 32) / (float)1.8 + (float)273.15;
                break;
            default:
                break;
        }
        return result;
    }
}
