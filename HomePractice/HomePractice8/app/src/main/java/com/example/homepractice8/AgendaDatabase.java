package com.example.homepractice8;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

@Database(entities = {Vacanta.class},version = 1)
@TypeConverters(ConverterDate.class)
public abstract class AgendaDatabase extends RoomDatabase {

    public abstract VacantaDAO returnDAO();
}
