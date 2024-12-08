package com.example.seminar4.myclasses;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface cameraDAO {

    @Insert
    public void insertCamera(Camera camera);

    @Query("select * from tabelcamere")
    public List<Camera> getCamera();

}
