package com.example.tp3.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Etab.class} ,version =1)
public abstract class MyDatabase2 extends RoomDatabase {
    public abstract Etab_dao mydao2();
}
