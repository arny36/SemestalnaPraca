package com.example.semestalnapraca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
/**
 * Trieda Poznamky nam sluzi na vytvorenie a zapis do databazy danej poznamy
 * Vyuzivam tu databazu firebase a konkretne pre realtime
 * Prepojenie s databazou bolo jednoduche pomocou Firebase tu v android studiu
 * */

public class Poznamky extends AppCompatActivity {

    private  Button btVytvorit;
    private EditText etNadpis, etText;
    private Toolbar mToolbar;
    private FirebaseAuth fAuth;
    private DatabaseReference fNotesDatabase;
    private FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poznamky);

        database = FirebaseDatabase.getInstance();


        btVytvorit = (Button) findViewById(R.id.poznamkaBT);
        etNadpis = (EditText) findViewById(R.id.nadpisET);
        etText = (EditText) findViewById(R.id.poznamkyET);
        mToolbar = (Toolbar) findViewById(R.id.poznamkaTB);

        //setSupportActionBar(mToolbar);
        //fNotesDatabase = FirebaseDatabase.getInstance().getReference().child("Notes").child(fAuth.getCurrentUser().getUid());
        database.getReference("skuska").toString();
        btVytvorit.setOnClickListener(new View.OnClickListener()   {
            @Override
            public void onClick(View view) {
                String nadpis =  etNadpis.getText().toString();
                String text = etText.getText().toString();
                if (!TextUtils.isEmpty(nadpis) && !TextUtils.isEmpty(text)) {
                    vytvorPoznamku(nadpis,text);
                } else {
                    Snackbar.make(view,"Fill empty fields", Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    /**
     * Metoda vytvor poznamku sluzi na  button vytvorenie poznamky
     * Do databazy zapise nadpis databazy a text ktory si v nej napiseme
     */
    private void vytvorPoznamku(String nadpis, String text) {

        fNotesDatabase = database.getReference(nadpis);
        fNotesDatabase.setValue(text).addOnCompleteListener( new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()) {
                    Toast.makeText(Poznamky.this, "Poznámka úspešne pridaná", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(Poznamky.this, "ERROR" , Toast.LENGTH_SHORT).show();

                }

            }
        });


    }




}