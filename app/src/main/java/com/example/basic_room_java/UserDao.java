package com.example.basic_room_java;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserDao {

    @Insert
    void insertRecord(User user);

}
