package com.example.tp3.db;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "etab")
public class Etab {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "etab_label")
    public String label;

    @ColumnInfo(name = "etab_name")
    public String name;

    @NonNull
    public String getLabel() {
        return label;
    }

    public void setLabel(@NonNull String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}