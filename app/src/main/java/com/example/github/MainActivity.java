package com.example.github;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private TextView tvX;
    private TextView tvY;
    private TextView tvZ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //textview-objekte referenzieren
        tvX = findViewById(R.id.textViewX);
        tvY = findViewById(R.id.textViewY);
        tvZ = findViewById(R.id.textViewZ);

        //Sensormanager
        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        //accleration sensor
        Sensor sensorAcc = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //register sensor listener
        sm.registerListener((SensorEventListener) this, sensorAcc, sm.SENSOR_DELAY_NORMAL);
    }





    @Override
    public void onSensorChanged(SensorEvent event) {
        tvX.setText("X:"+event.values[0]);
        tvY.setText("Y:"+event.values[1]);
        tvZ.setText("Z:"+event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}