package com.example.miprimeraaplicacion;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tempVal;
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorLuz();
    }

    @Override
    protected void onResume() {
        super.onResume();
        iniciar();
    }

    @Override
    protected void onPause() {
        super.onPause();
        detener();
    }

    private void iniciar(){
        sensorManager.registerListener(sensorEventListener, sensor, 2000*1000);
    }

    private void detener(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    private void sensorLuz(){
        tempVal = findViewById(R.id.lblSensorAcelerometro);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (sensor ==null){
            tempVal.setText("Tu dispositivo, no tiene el sensor de acelerometro");
            finish();
        }
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                double x = event.values[0];
                double y = event.values[1];
                double z = event.values[2];
                tempVal.setText("Desplazamiento X= "+ x + "; Y="+y + "; Z="+z);


            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
    }
}
