package com.example.semestalnapraca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Menu;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
/*
* Tato trieda sluzi na vypis všetky predmetov a vymazanie ich
* Funkcne je vytvaranie poznamok pomocou + hore vpravo
* */
public class PoznamkaMenu extends AppCompatActivity {
    private DatabaseReference fNotesDatabase;
    private FirebaseDatabase database;
    private Map<String,String> poznamky;
    private FirebaseAuth fAuth;
    private GridLayoutManager gridLayoutManager;
    private DatabaseReference dtbRef;




    private RecyclerView listPoznamok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*listPoznamok = findViewById(R.id.listPoznamokRW);
        gridLayoutManager= new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false);
        listPoznamok.setHasFixedSize(true);
        listPoznamok.setLayoutManager(gridLayoutManager);*/
        dtbRef = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_poznamka_menu);

        fAuth = FirebaseAuth.getInstance();

        //nacitajPoznamky();

    }




/*
    private void nacitajPoznamky() {
        poznamky=new HashMap<>();
        database.getInstance().getReference().get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (!task.isSuccessful()) {
                    Log.e("firebase", "Error getting data", task.getException());
                }
                else {
                   // Log.d("firebase", String.valueOf(task.getResult().getValue()));
                    poznamky = (Map<String, String>) task.getResult().getValue();
                    //poznamky.put(task.getResult().getKey(), (String) task.getResult().getValue());
                }
            }
        });
        for (Map.Entry<String,String> entry : poznamky.entrySet()){
            Log.d("poznamky", entry.getKey() + " , " + entry.getValue());

        }

    }
*/

/*
* Metoda sluzi na vykreslenie vytvarania poznamky
* */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.nova_poznamka,menu);
        return true;
    }
/*
 * Metoda sluzi na  vytvaranie poznamky a prepnunie sa k jej vytvaraniu
 * */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //super.onCreateOptionsMenu((Menu) item);
        switch (item.getItemId()) {
            case R.id.nova_poznamka_btn:
                Intent newIntent = new Intent(PoznamkaMenu.this, Poznamky.class);
                startActivity(newIntent);
                break;
        }
        return true;
    }

}