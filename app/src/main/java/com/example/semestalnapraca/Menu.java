package com.example.semestalnapraca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 *Trieda nam sluzi na vytvaranie menu  prechodna trieda cez ktoru si otvaram miniaplikacie
 * Medzi triedy ktore otvaram patri kalkulacka, hubarska prirucka pocasie mapa a poznamky
 */
public class Menu extends AppCompatActivity {

    Button BKalkulacka, BHubarskaPrirucka, BPocasie , BMapa , BPoznamky;
    private static final String KALKULACKA_WELCOME = "kalkulacka";
    private static final String PRIRUCKA_WELCOME = "prirucka";
    private static final String POCASIE_WELCOME = "pocasie";
    private static final String MAPA_WELCOME = "mapa";

    /**
     *konstruktor danej  triedy
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        BPocasie = findViewById(R.id.pocasieBtn);
        BPocasie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvorPocasie();
            }
        });
        BHubarskaPrirucka = findViewById(R.id.hubraskaPriruckaBtn);
        BHubarskaPrirucka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvorHubarskuPrirucku();
            }
        });
        BKalkulacka = (Button) findViewById(R.id.kalkulackaBtn);
        BKalkulacka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvorKalkulacku();
            }
        });
        BMapa = (Button) findViewById(R.id.mapaBtn);
        BMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvorMapu();
            }
        });
        BPoznamky = (Button) findViewById(R.id.MenuPoznamkabtn);
        BPoznamky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                otvorPoznamku();
            }
        });

    }

    /**
     * metoda na otvorenie kalkulacky a notifikacia pri otvoreni kalkulacky s vlastnym symbolom
     */
    private void otvorKalkulacku () {
        Intent intent = new Intent(Menu.this, Kalkulacka.class);
        startActivity(intent);
        createNotificationChannel(KALKULACKA_WELCOME, "kalkulacka", "Vitajte v kalkulačke, pomocou t" +
                "tlačítok naklikávate čísla");

    }

    /**
     * metoda na otvorenie prirucky a notifikacia pri otvoreni prirucky s vlastnym symbolom
     */
    private void otvorHubarskuPrirucku() {
        Intent intent = new Intent(Menu.this, HubarskaPrirucka.class);
        startActivity(intent);
        createNotificationChannel(KALKULACKA_WELCOME, "Príručka",
                "Vitajte v hubárksej príručke pomocou naklikavania tlacitok pocitajte.");

    }

    /**
     *metoda na otvorenie pocasia
     */
    private void otvorPocasie() {
        Intent intent = new Intent(Menu.this, Pocasie.class);
        startActivity(intent);
        createNotificationChannel(KALKULACKA_WELCOME, "Počasie", "Vitajte v počasí, tu zistíte teplotu, tlak a svetlo.");

    }
    /**
     *metoda na otvorenie mapy
     */
    private void otvorMapu() {
        Intent intent = new Intent(Menu.this, Mapa.class);
        startActivity(intent);
        createNotificationChannel(KALKULACKA_WELCOME, "Mapa",
                "Vitajte v mini-mape aktualne sa nachádzate v Žiline .");


    }
    /**
     *metoda na otvorenie poznamok
     */
    private void otvorPoznamku() {
        Intent intent = new Intent(Menu.this, PoznamkaMenu.class);
        startActivity(intent);
        createNotificationChannel(KALKULACKA_WELCOME, "Poznamkový blok",
                "Vitajte v poznámkovom bloku .");


    }

    /**
     *Metoda ktora nastavi každému notifikaciu podla mapametrov
     * kde nazov je Premenna
     * nazovTitle je nazov ako chceme notifikaciu volat
     * text je text ktory sa vypise
     */
    public void createNotificationChannel(String nazov, String nazovTitle , String text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            NotificationChannel channel = new NotificationChannel(nazov, nazovTitle, importance);
            channel.setDescription(text);
            notificationManager.createNotificationChannel(channel);
        }
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, nazov)
                .setSmallIcon(R.drawable.info)
                .setContentTitle(nazovTitle)
                .setContentText(text)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat mNotify = NotificationManagerCompat.from(this);
        mNotify.notify(3, mBuilder.build());
    }




}
