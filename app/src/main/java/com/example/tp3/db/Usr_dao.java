package com.example.tp3.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface Usr_dao {

    @Insert(onConflict= OnConflictStrategy.IGNORE)
    void adduser(User user);

    @Query("select * from users where user_login = :login")
    List<User> getUser(String login);

    @Query("select * from users")
    List<User> getUsers();

    @Delete
    void deletuser(User user);

    @Update
    void updatuser(User user);
}