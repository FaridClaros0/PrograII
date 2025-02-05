package com.example.miprimeraaplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tempVal;
    RadioGroup rgb;
    RadioButton opt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempVal = findViewById(R.id.txtNum1);
                double num1 = Double.parseDouble(tempVal.getText().toString());
                tempVal = findViewById(R.id.txtNum2);
                double num2 = Double.parseDouble(tempVal.getText().toString());
                double factorial =1;

                double respuesta = 0.0;

                opt = findViewById(R.id.optSuma);
                if (opt.isChecked()) {
                    respuesta = num1 + num2;
                }
                opt = findViewById(R.id.optResta);
                if (opt.isChecked()) {
                    respuesta = num1 - num2;
                }
                opt = findViewById(R.id.optMultiplicacion);
                if (opt.isChecked()) {
                    respuesta = num1 * num2;
                }
                opt = findViewById(R.id.optDivision);
                if (opt.isChecked()) {
                    respuesta = num1 / num2;
                }
                opt = findViewById(R.id.optExponenciacion);
                if (opt.isChecked()){
                    respuesta = Math.pow(num1,num2);
                }

                opt =findViewById(R.id.optRaiz);
                if (opt.isChecked()){
                    respuesta = num1 = Math.sqrt(num2);
                }

                opt =findViewById(R.id.optFactorial);
                if (opt.isChecked()) {
                    while (num1!=0){
                        factorial = factorial * num1;
                        num1 = num1 - 1;
                    }
                    respuesta= factorial;
                }

                opt =findViewById(R.id.optModulo);
                if (opt.isChecked()) {

                    respuesta = num1 % num2;
                }

                opt =findViewById(R.id.optMayor);
                if (opt.isChecked()) { if(num1>num2) {respuesta = num1;
                if (num2>num1);
                    respuesta= num2;}

                }

                tempVal = findViewById(R.id.lblRespuesta);
                tempVal.setText("Respuesta: "+ respuesta);
            }
        });

    }
}