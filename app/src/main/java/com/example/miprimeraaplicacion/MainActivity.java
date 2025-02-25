package com.example.miprimeraaplicacion;

import android.Manifest;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TabHost tbh;
    TextView tempVal;
    Spinner spn;
    Button btn;
    conversor objconversor = new conversor();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbh = findViewById(R.id.tbhConversor);
        tbh.setup();

        tbh.addTab(tbh.newTabSpec("Monedas").setContent(R.id.tabAreas).setIndicator("AREAS", null));
        tbh.addTab(tbh.newTabSpec("Longitud").setContent(R.id.tabTarifa).setIndicator("TARIFA", null));

        btn = findViewById(R.id.btnCalcular);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opcion = tbh.getCurrentTab();

                spn = findViewById(R.id.spnDeAreas);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spnAAreas);
                int a = spn.getSelectedItemPosition();

                tempVal = findViewById(R.id.txtCantidad);
                double cantidad = Double.parseDouble(tempVal.getText().toString());


                tempVal = findViewById(R.id.lblRespuesta);
                double respuesta = objconversor.convertir(opcion, de, a, cantidad);
                tempVal.setText("Respuesta: "+ respuesta);;
            }
        });

    }
    class conversor {
        double[][] valores = {
                {1, 0.006944, 0.1111, 0.092903, 0.000031, 0.000007, 0.00000929},//piecuadrado
        };

        public double convertir(int opcion, int de, int a, double cantidad) {
            return valores[opcion][a] / valores[opcion][de] * cantidad;
        }
    }


}


