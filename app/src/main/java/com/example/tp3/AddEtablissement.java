package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tp3.db.Etab;
import com.example.tp3.db.MyDatabase;
import com.example.tp3.db.MyDatabase2;

import java.util.List;

public class AddEtablissement extends AppCompatActivity {
    static Etab etab = new Etab();
    static MyDatabase2 mydatabase;
    EditText label;
    EditText nom;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etablissement);
        getSupportActionBar().setTitle("L'ajout d'un établissement");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void myClick(View v) {
        add = this.findViewById(R.id.ajouter);
        label = findViewById(R.id.labelE);
        nom = findViewById(R.id.nomE);
        mydatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase2.class, "etab_bd").allowMainThreadQueries().build() ;
        etab.label = label.getText().toString();
        etab.name = nom.getText().toString();

        if ( !(label.getText().toString()).matches("")) {
            List<Etab> etb = AddEtablissement.mydatabase.mydao2().getEtab(label.getText().toString());
            switch (v.getId()) {
                case R.id.ajouter:
                    if (etb.size() != 0) {
                        Toast.makeText(getApplicationContext(), "Impossible d'ajouter l'établissement", Toast.LENGTH_SHORT).show();
                        break;
                    } else {
                        AddEtablissement.mydatabase.mydao2().addetab(etab);
                        Toast.makeText(getApplicationContext(), "Parfait l'établissement est crée", Toast.LENGTH_SHORT).show();
                        break;
                    }

            }
        }
    }

    public void AjouterE(View view) { myClick(view); }
}
