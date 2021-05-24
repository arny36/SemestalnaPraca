package com.example.semestalnapraca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Hubarska prirucka nam sluzi na rychle prezretie hub
 * Vyuzil som v nich tabulky a grafiku na zobrazenie obrazkov
 * nacitaval som huby a ich popis zo stringov a potom vkladat do tabulky
 * pri kliknuti na tabulku sa presuniem do triedy detaily kde sa nachadzaju obrazky
 */
public class HubarskaPrirucka extends AppCompatActivity {
    ListView tabulkaLVP;
    String[] hubyP;
    String[] popisHubP;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hubarska_prirucka);

        Resources res = getResources();
        tabulkaLVP = (ListView) findViewById(R.id.tabulkaLV);
        hubyP = res.getStringArray(R.array.huby);
        popisHubP = res.getStringArray(R.array.popisy);

        Polozky polozky = new Polozky(this,hubyP,popisHubP);
        tabulkaLVP.setAdapter(polozky);

        tabulkaLVP.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detaily = new Intent(getApplicationContext(), Detaily.class);
                detaily.putExtra("POLOZKA", position);
                startActivity(detaily);

            }
        });
    }
}
