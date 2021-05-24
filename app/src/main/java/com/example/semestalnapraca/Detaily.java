package com.example.semestalnapraca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

/**
 * Tato trieda sluzi na vykreslenie obrazku
 */
public class Detaily extends AppCompatActivity {
    /**
     *trieda nám sluzi na nakreslenie obrazku ak sa tam nachádza
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detaily);

        Intent in  = getIntent();
        int index = in.getIntExtra("POLOZKA", -1);

        if (index > -1) {
            int pic = getImg(index);
            ImageView img = (ImageView) findViewById(R.id.imageView);
            orezanieObrazku(img,pic);

        }
    }

    /**
     * vybranie obrazku
     * @param index parameter sluzi na vybratie obrazku

     */
    private int getImg(int index) {
        switch (index) {
            case 0: return R.drawable.dubak;
            case 1: return R.drawable.suchohrib;
            case 2: return R.drawable.modrak;
            case 3: return R.drawable.muchotravka_zelena;
            case 4: return R.drawable.horcak;
            case 5: return R.drawable.muchotravka_cervena;
            case 6: return R.drawable.mucho_tigrovana;
            case 7: return R.drawable.masliak;
            case 8: return R.drawable.hrib_brezovy;
            case 9: return R.drawable.sampion;
            case 10: return R.drawable.prasivka;
            case 11: return R.drawable.pavucinovec;
            case 12: return R.drawable.smrcok;
            default: return -1;

        }
    }

    /**
     *Trieda nam sluzi na zmensenie obrazku podla toho ci je vacsi ako dany screen
     * pomocou kontroly ci je vacsi ako obrazovka som ho zmensil
     */
    private void orezanieObrazku(ImageView obrazok, int cisloObrazka) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), cisloObrazka, options);
        int obrazokSirka = options.outWidth;
        int screenSirka = screen.getWidth();
        if(obrazokSirka > screenSirka) {
            int pomer= Math.round((float)obrazokSirka / (float)screenSirka);
            options.inSampleSize = pomer;

        }
        options.inJustDecodeBounds = false;
        Bitmap orezanyObrazok = BitmapFactory.decodeResource(getResources(),cisloObrazka,options);
        obrazok.setImageBitmap(orezanyObrazok);

    }
}
