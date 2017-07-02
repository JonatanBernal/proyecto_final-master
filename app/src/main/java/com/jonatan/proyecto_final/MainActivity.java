package com.jonatan.proyecto_final;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    boolean decimal = true,sum = false,rest = false,mult = false,div = false;
    Double resultado = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,bac,bdel,bdiv,bmult,brest,bsum,bpoint,bequal;

        b0 = (Button) findViewById(R.id.button0);
        b0.setOnClickListener(this);
        b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(this);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(this);
        b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(this);
        b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(this);
        b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(this);
        b6 = (Button) findViewById(R.id.button6);
        b6.setOnClickListener(this);
        b7 = (Button) findViewById(R.id.button7);
        b7.setOnClickListener(this);
        b8 = (Button) findViewById(R.id.button8);
        b8.setOnClickListener(this);
        b9 = (Button) findViewById(R.id.button9);
        b9.setOnClickListener(this);
        bac = (Button) findViewById(R.id.buttonreset);
        bac.setOnClickListener(this);
        bdel = (Button) findViewById(R.id.buttondel);
        bdel.setOnClickListener(this);
        bdiv = (Button) findViewById(R.id.buttondiv);
        bdiv.setOnClickListener(this);
        bmult = (Button) findViewById(R.id.buttonmult);
        bmult.setOnClickListener(this);
        brest = (Button) findViewById(R.id.buttonrest);
        brest.setOnClickListener(this);
        bsum = (Button) findViewById(R.id.buttonsum);
        bsum.setOnClickListener(this);
        bpoint = (Button) findViewById(R.id.buttonpoint);
        bpoint.setOnClickListener(this);
        bequal = (Button) findViewById(R.id.buttonequal);
        bequal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView tv = (TextView) findViewById(R.id.text_view);
        String a = tv.getText().toString();


        switch (v.getId()) {
            case R.id.button0:
                tv.setText(a+"0");
                break;
            case R.id.button1:
                tv.setText(a+"1");
                break;
            case R.id.button2:
                tv.setText(a+"2");
                break;
            case R.id.button3:
                tv.setText(a+"3");
                break;
            case R.id.button4:
                tv.setText(a+"4");
                break;
            case R.id.button5:
                tv.setText(a+"5");
                break;
            case R.id.button6:
                tv.setText(a+"6");
                break;
            case R.id.button7:
                tv.setText(a+"7");
                break;
            case R.id.button8:
                tv.setText(a+"8");
                break;
            case R.id.button9:
                tv.setText(a+"9");
                break;
            case R.id.buttonreset:
                decimal = true;
                tv.setText("");
                break;
            case R.id.buttondel:
                if (a.equals("")) {
                    return;
                }
                else {
                    tv.setText(tv.getText().toString().substring(0,tv.getText().toString().length()-1));
                }
                break;
            case R.id.buttonsum:
                if (a.equals("")) {
                    return;
                }
                else {
                    if (resultado == 0) {
                        resultado = Double.parseDouble(a);
                    }
                    else {
                        resultado = resultado + Double.parseDouble(a);
                    }
                    tv.setText("");
                    decimal = true;
                    sum = true;
                    rest = false;
                    mult = false;
                    div = false;
                }
                break;
            case R.id.buttonrest:
                if (a.equals("")) {
                    tv.setText("-");
                }
                else {
                    if (resultado == 0) {
                        resultado = Double.parseDouble(a);
                    }
                    else {
                        resultado = resultado - Double.parseDouble(a);
                    }
                    tv.setText("");
                    decimal = true;
                    sum = false;
                    rest = true;
                    mult = false;
                    div = false;
                }
                break;
            case R.id.buttonpoint:
                if (a.equals("")) {
                    return;
                }
                else if(decimal) {
                    decimal = false;
                    tv.setText(a + ".");
                }
                break;
            case R.id.buttonmult:
                if (a.equals("")) {
                    return;
                }
                else {
                    if (resultado == 0) {
                        resultado = Double.parseDouble(a);
                    }
                    else {
                        resultado = resultado * Double.parseDouble(a);
                    }
                    tv.setText("");
                    decimal = true;
                    sum = false;
                    rest = false;
                    mult = true;
                    div = false;
                }
                break;
            case R.id.buttondiv:
                if (a.equals("")) {
                    return;
                }
                else {
                    if (resultado == 0) {
                        resultado = Double.parseDouble(a);
                    }
                    else {
                        resultado = resultado / Double.parseDouble(a);
                    }
                    tv.setText("");
                    decimal = true;
                    sum = false;
                    rest = false;
                    mult = false;
                    div = true;
                }
                break;
            case R.id.buttonequal:
                if (a == "") {
                    return;
                }
                else {
                    if (sum) {
                        resultado = Double.parseDouble(a) + resultado;
                        tv.setText(resultado.toString());
                        sum = false;
                    }
                    else if (mult) {
                        resultado = Double.parseDouble(a) * resultado;
                        tv.setText(resultado.toString());
                        mult = false;
                    }
                    else if (div) {
                        resultado = resultado / Double.parseDouble(a);
                        tv.setText(resultado.toString());
                        div = false;
                    }
                    else if (rest) {
                        resultado = resultado - Double.parseDouble(a);
                        tv.setText(resultado.toString());
                        rest = false;
                    }
                }
                resultado = 0.0;
                break;
        }

    }
}
