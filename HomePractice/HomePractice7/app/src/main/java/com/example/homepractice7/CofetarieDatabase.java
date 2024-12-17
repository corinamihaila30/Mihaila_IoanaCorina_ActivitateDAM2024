package com.example.homepractice7;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {Prajitura.class},version = 1)
@TypeConverters(ConverterDate.class)
public abstract class CofetarieDatabase extends RoomDatabase {

    public abstract PrajituraDAO returnDAO();
}
