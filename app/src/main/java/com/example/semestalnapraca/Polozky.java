package com.example.semestalnapraca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * trieda nam sluzi na konfiguráciu  a pracu s hubami a popis výslednu tabulku so vsetkym
 */
public class Polozky extends BaseAdapter {
    LayoutInflater mInflater;
    String[] huby;
    String[] popisHub;
/**
 *vytvorenie konstruktora pre polozku a priradenie ich do listu
 */
    public Polozky(Context c, String[] huby ,  String[] popis) {
        this.huby = huby;
        this.popisHub = popis;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /**
     *dlzka listu huby
     */
    @Override
    public int getCount() {
        return huby.length;
    }
/**
 * vratenie danej huby z pozicie
 */
    @Override
    public Object getItem(int position) {
        return huby[position];
    }
/**
 * navrat pozicie
 */
    @Override
    public long getItemId(int position) {
        return position;
    }
/**
 * vyraba tabulky pomocou hub a popisov
 */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = mInflater.inflate(R.layout.activity_polozky, null);
        TextView menoHub = (TextView) v.findViewById(R.id.menoHubyTV);
        TextView popis = (TextView) v.findViewById(R.id.popisHubyTV);

        String menoHuby = huby[position];
        String popisJednejHuby = popisHub[position];

        menoHub.setText(menoHuby);
        popis.setText(popisJednejHuby);

        return v;
    }
}
