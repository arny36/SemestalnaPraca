package com.example.semestalnapraca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;

/**
 * pocasie trieda nam sluzi na aktualne pocasie cize svetlo teplota a tlak vzduchu
 */
public class Pocasie extends AppCompatActivity implements SensorEventListener {

    private TextView aktualnaTeplota, aktualnyTlakVzduchu , aktualneSvetlo;
    private SensorManager sensorManager;
    private Sensor teplotaSensor, tlakVzduchuSensor , svetloSensor;
    private boolean jeDostupnaTeplota, jeDostupnyTlak, jeSvetlo;

    /**
     *zadeklarovanie si sensorov a nacitanie dat
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocasie);

        aktualnaTeplota = findViewById(R.id.akutualnaTeplotaTV);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        aktualnyTlakVzduchu = findViewById(R.id.aktualnyTlakVzduchuTV);
        aktualneSvetlo = findViewById(R.id.svetloTV);

        if (sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE) != null) {
            teplotaSensor = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
            jeDostupnaTeplota = true;
        } else {
            aktualnaTeplota.setText("Teplota sa nepodarila zmerať");
            jeDostupnaTeplota = false;

        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT) != null) {
            svetloSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
            jeSvetlo = true;
        } else {
            aktualneSvetlo.setText("Svetlo sa nepodarilo zmerať");
            jeSvetlo = false;

        }


        aktualnyTlakVzduchu = findViewById(R.id.aktualnyTlakVzduchuTV);
        if (sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE) != null) {
            tlakVzduchuSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
            jeDostupnyTlak = true;
        } else {
            aktualnaTeplota.setText("Tlak sa nepodaril zmerať");
            jeDostupnyTlak = false;

        }


    }

    /**
     * pomocou eventu ktory ma vsetky udaje a event value0 co znaci udaj danej operacie z tych co tam mam
     * nacitava mi do textu udaje namerane zo sensorov a pri svetle som usudil ze ak by som tam dal lux jednotka svetla nik by z toho nic nevedel
     * tak som radsej pomocou wikipedie nasiel ako by priblizne malo byt a do TextView som pisal ci ma byt jasno polooblacno atd
     */
    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_AMBIENT_TEMPERATURE) {

            aktualnaTeplota.setText(event.values[0] + " °C");
        }
        if (event.sensor.getType() == Sensor.TYPE_PRESSURE) {

            aktualnyTlakVzduchu.setText(event.values[0] + " hPa");
        }
        if (event.sensor.getType() == Sensor.TYPE_LIGHT) {

            if (event.values[0] >= 20000) {
                aktualneSvetlo.setText("Jasno");
            } else if (event.values[0] <20000 && event.values[0] >= 10000) {
                aktualneSvetlo.setText("Polooblacno");

            } else if (event.values[0] < 10000 && event.values[0] >= 5000) {
                aktualneSvetlo.setText("Zamracene");
            } else {
                aktualneSvetlo.setText("Noc");

            }



        }
    }



    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    /**
     * odregistrovanie citacov
     */

    @Override
    protected void onPause() {
        super.onPause();

        if (jeDostupnaTeplota) {
            sensorManager.unregisterListener(this);

        }
        if (jeDostupnyTlak) {
            sensorManager.unregisterListener(this);

        }
        if (jeSvetlo) {
            sensorManager.unregisterListener(this);

        }
    }

    /**
     * zaregistrovanie citaca daneho registra
     */
    @Override
    protected void onResume() {
        super.onResume();
        if (jeDostupnaTeplota) {
            sensorManager.registerListener(this, teplotaSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (jeDostupnyTlak) {
            sensorManager.registerListener(this, tlakVzduchuSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (jeSvetlo) {
            sensorManager.registerListener(this, svetloSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
}
