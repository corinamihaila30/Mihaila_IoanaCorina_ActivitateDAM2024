package com.example.seminar4.myclasses;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Camera.class},version = 1)
public abstract class CameraDatabase extends RoomDatabase {
    public abstract cameraDAO getDatabase();
}
