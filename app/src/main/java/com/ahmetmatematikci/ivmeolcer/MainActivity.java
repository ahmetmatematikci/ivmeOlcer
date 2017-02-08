package com.ahmetmatematikci.ivmeolcer;


import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener{
    TextView textView;
    String metin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView = new TextView(this);
        setContentView(textView);
        SensorManager manager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        if (manager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() ==0) {
            textView.setText("Ivme Olcer Yok");
        } else {
            Sensor ivmeOlcer = manager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);

            if (!manager.registerListener(this, ivmeOlcer,SensorManager.SENSOR_DELAY_GAME)){
                textView.setText("Sensor Kayıt Edilmiyor");
            }
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        metin = "";
        metin ="x: ";
        metin = metin + sensorEvent.values[0];
        metin = metin + ", y: " ;
        metin = metin + sensorEvent.values[1];
        metin = metin  + ", z: ";
        metin = metin + sensorEvent.values[2];
        textView.setText(metin.toString());

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

