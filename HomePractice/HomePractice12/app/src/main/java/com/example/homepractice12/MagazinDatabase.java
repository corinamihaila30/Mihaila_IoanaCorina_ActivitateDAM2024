package com.example.homepractice12;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Produs.class},version = 1)
public abstract class MagazinDatabase extends RoomDatabase {

    public abstract ProdusDAO returnDao();
}
