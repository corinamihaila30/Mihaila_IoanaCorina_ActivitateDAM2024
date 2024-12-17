package com.example.homepractice12;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProdusDAO {

    @Insert
    public void insertProdus(Produs p );

    @Query("select * from produs")
    public List<Produs> selectAll();

    @Query("delete from produs")
    public void deleteAll();
}
