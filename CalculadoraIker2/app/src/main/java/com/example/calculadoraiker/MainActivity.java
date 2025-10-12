package com.example.calculadoraiker;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btn_suma;
    private Button btn_resta;
    private Button btn_multiplicacion;
    private Button btn_division;

    private EditText numero1;
    private EditText numero2;
    private TextView respuesta;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.numero1);
        numero2 = findViewById(R.id.numero2);
        respuesta = findViewById(R.id.respuesta);


        btn_suma = findViewById(R.id.btn_suma);
        btn_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                respuesta.setText(String.valueOf(suma( Double.parseDouble(numero1.getText().toString()), Double.parseDouble(numero2.getText().toString()))));
            }
      });

        btn_resta = findViewById(R.id.btn_resta);
        btn_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                respuesta.setText(String.valueOf(resta( Double.parseDouble(numero1.getText().toString()), Double.parseDouble(numero2.getText().toString()))));
            }
        });

        btn_multiplicacion = findViewById(R.id.btn_multiplicacion);
        btn_multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                respuesta.setText(String.valueOf(multiplicacion( Double.parseDouble(numero1.getText().toString()), Double.parseDouble(numero2.getText().toString()))));
            }
        });

        btn_division = findViewById(R.id.btn_division);
        btn_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                respuesta.setText(String.valueOf(division( Double.parseDouble(numero1.getText().toString()), Double.parseDouble(numero2.getText().toString()))));
            }
        });
    }


    public double suma(double num1, double num2){
        return num1 + num2;
    }

    public double resta(double num1, double num2){
        return num1 - num2;
    }
    public double multiplicacion(double num1, double num2){
        return num1 * num2;
    }

    public double division(double num1, double num2){
        double respuesta = 0;
        if(num2 != 0){
            respuesta = num1 / num2;
        }
        return respuesta;
    }

}