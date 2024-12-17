package com.example.homepractice7;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface PrajituraDAO {

    @Insert
    public void insertPrajitura(Prajitura p);

    @Query("select * from prajitura")
    public List<Prajitura> selectPrajituri();
}
