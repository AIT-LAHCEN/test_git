package com.example.tp3.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Etab_dao {

    @Insert(onConflict= OnConflictStrategy.IGNORE)
    void addetab(Etab etab);

    @Query("select * from etab where etab_label = :etab_label")
    List<Etab> getEtab(String etab_label);

    @Query("select * from etab")
    List<Etab> getEtab();

    @Delete
    void deletetab(Etab etab);

    @Update
    void updatetab(Etab etab);
}