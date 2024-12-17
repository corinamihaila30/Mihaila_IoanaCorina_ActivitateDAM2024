package com.example.homepractice11;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Student.class},version = 1)
public abstract class FacultateDatabase extends RoomDatabase {
    public abstract StudentDA0 returnDAO();
}
