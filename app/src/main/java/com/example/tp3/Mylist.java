package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class Mylist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);
        int VERTICAL_ITEM_SPACE = 48;
        // get the reference of RecyclerView
        RecyclerView rv = findViewById(R.id.list);
        // set a LinearLayoutManager with default vertical orientation
        rv.setLayoutManager(new LinearLayoutManager(this));
        //add ItemDecoration
        rv.addItemDecoration(new VerticalSpaceItemDecoration(VERTICAL_ITEM_SPACE));
        ArrayList Etablissements = new ArrayList<>(Arrays.asList(
                new Etablissement("ENSIAS", "Ecole Nationale Supérieure d'Informatique et d'Analyse des Systèmes", R.drawable.ensias,33.984276, -6.867645),
                new  Etablissement("FMP", "Faculté de Medcine et de Pharmacie", R.drawable.md,33.983032, -6.855890),
                new  Etablissement ("FMD", "Faculté de Medcine Dentaire", R.drawable.fmd,33.980725, -6.870307),
                new  Etablissement ("ENSET", "Eccole Normale Supérieure de l'Enseignement Technique", R.drawable.enset,33.968727, -6.877365),
                new  Etablissement ("ESI", "Ecole de Sciences de l'information", R.drawable.esi,33.982388, -6.865591),
                new  Etablissement ("EMI", "Ecole Mohammadia d'Ingénieurs", R.drawable.emi,33.998187, -6.853837)
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


    //Question 12
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
                Intent intent = new Intent(Mylist.this,AddEtablissement.class);
                startActivity(intent);
                break;
            case R.id.item3:
                Toast.makeText(this, "Supprimer un établissement",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
