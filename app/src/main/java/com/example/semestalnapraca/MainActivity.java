package com.example.semestalnapraca;

import androidx.annotation.NonNull;
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
import android.widget.EditText;
import android.widget.TextView;

/**
 *Hlavna trieda main z ktoreho som zacinal
 *Aplikacia sluzi ako prirucka do prirody alebo len tak do zivota
 *Su  v nej uzitocne veci ktore clovek vyuzije kazdy den
 */

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "Zly_login";
    private Button Prihlasenie , RegistraciaBtn;
    private EditText Email , Heslo;
    private TextView Pokusy;
    private int Pocitadlo = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Prihlasenie = (Button)findViewById(R.id.prihlasenieBtn);
        Prihlasenie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kontrola(Email.getText().toString(), Heslo.getText().toString());
            }
        });
        Heslo = (EditText)findViewById(R.id.hesloUzivatelaET);
        Email = (EditText) findViewById(R.id.emailET);
        Pokusy = (TextView) findViewById(R.id.pokusyNaPrihlasenieTV);
        Pokusy.setText("Zostávajúce pokusy na prihlásenie : 3");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "Zly_login", importance);
     
            notificationManager.createNotificationChannel(channel);
        }
    }

    /**
     * Metoda ktora urcuje ci som zadal dobre meno a heslo  ak je nespravne potom vypise notifikaciu s vlastnou ikonkou
     * Ked zadam nespravne heslo odpocita sa pokus prihlasenia zaklad su 3 potom sa login zablokuje vypne
     * @param meno sluzi ako login  meno cize to cim sa prihlasujeme
     * @param heslo sluzi ako heslo cim sa prihlasujeme
     *              defaultne su student ako  meno a 1111 ako heslo
     */
    private void kontrola(String meno, String heslo) {
        if (meno.equals("Admin") && heslo.equals("")) {
            Intent intent = new Intent(this, Menu.class);
            startActivity(intent);
        } else {
            Pocitadlo--;
//notifikacia
            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)

                    .setSmallIcon(R.drawable.error_notifikacia)
                    .setContentTitle("Nesprávne prihlasenie")
                    .setContentText("Ostávajú vám : " + String.valueOf(Pocitadlo) + " pokusy.")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setStyle(new NotificationCompat.BigTextStyle());

            NotificationManagerCompat mNotify = NotificationManagerCompat.from(this);
            NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

            notificationManager.notify(1, mBuilder.build());
            mNotify.notify(1, mBuilder.build());
            Pokusy.setText("Zostávajúce pokusy na prihlásenie : " + String.valueOf(Pocitadlo)); //nastavenie textu pod prihlasovaním
            // if zastavi tlacidlo uz sa nebude dat stlacit
            if (Pocitadlo == 0) {

                Prihlasenie.setEnabled(false);
            }
        }

    }

    /**
     * Metoda sluzi na uchovavanie pamati pri otacani
     */
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("pokusy",Pokusy.getText().toString());
        outState.putString("meno", Email.getText().toString());
        outState.putString("heslo", Heslo.getText().toString());
        outState.putInt("pocitadlo", Pocitadlo);
        super.onSaveInstanceState(outState);
    }

    /**
     *metoda sluzi na nacitanie udajov ktore sa vymazali pri otacani ale ulozili sme ich
     */
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);


        Pocitadlo = savedInstanceState.getInt("pocitadlo");
        Pokusy.setText(savedInstanceState.getString("pokusy"));
        Email.setText(savedInstanceState.getString("meno"));
        Heslo.setText(savedInstanceState.getString("heslo"));

    }


}
