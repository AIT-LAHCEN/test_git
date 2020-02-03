package com.example.tp2;

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.*;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.recyclerview.widget.RecyclerView;



public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList Etablissements;

    public MyAdapter(Mylist mylist, ArrayList Etablissements){
        super();
        this.Etablissements = Etablissements;
    }


    @Override
    // retournele nb total de cellule que contiendra la liste
    public int getItemCount() {

        return Etablissements.size();
    }

    @Override
    //crée la vu d'une cellule
    // parent pour créer la vu et int pour spécifier le type de la cellule si on a plusieurrs type (orgnaisation differts)
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //pour créer un laouyt depuis un XML
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    //appliquer ne donnée à une vue
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Etablissement Etab= (Etablissement) Etablissements.get(position);

        System.out.println("Vname =" + Etab.getName());
        System.out.println("position=" + position);

        //  System.out.println("position =" + position);
        holder.display(Etab);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView label;
        private final TextView name;
        private final ImageView img;

        //  private Pair<String, String> currentPair;
        private Etablissement currentEtab;


        public MyViewHolder(final View itemView) {
            super(itemView);

            label = itemView.findViewById(R.id.label);
            name = itemView.findViewById(R.id.name);
            img=  itemView.findViewById(R.id.img);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    new AlertDialog.Builder(itemView.getContext())
                            .setTitle(currentEtab.getLabel())
                            .show();
                }
            });
        }

        public void display(Etablissement Etab) {
            currentEtab = Etab;
            name.setText(Etab.getName());
            label.setText(Etab.getLabel());
            img.setImageResource(Etab.getImage());

        }
    }



}