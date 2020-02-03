package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Mylist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);
        // get the reference of RecyclerView
        RecyclerView rv = findViewById(R.id.list);
        // set a LinearLayoutManager with default vertical orientation
        rv.setLayoutManager(new LinearLayoutManager(this));

        ArrayList Etablissements = new ArrayList<>(Arrays.asList(
                new Etablissement("ENSIAS", "Ecole Nationale Supérieure d'Informatique et d'Analyse des Systèmes", R.drawable.ensias),
                new  Etablissement("FMP", "Faculté de Medcine et de Pharmacie", R.drawable.md),
                new  Etablissement ("FMD", "Faculté de Medcine Dentaire", R.drawable.fmd)
        ));

        // call the constructor of MyAdapter to send the reference and data to Adapter
        rv.setAdapter(new MyAdapter(this, Etablissements));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    // TODO Auto-generated method stub
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        // On peut créer le menu via le code
            case R.id.item1:
                Toast.makeText(this, "à propos",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "Ajouter un établissement",
                        Toast.LENGTH_LONG).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "Supprimer un établissement",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
