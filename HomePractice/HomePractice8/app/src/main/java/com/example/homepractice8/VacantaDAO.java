package com.example.homepractice8;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface  VacantaDAO {

    @Insert
    public abstract void insertVacanta(Vacanta v);

    @Query("select * from vacanta")
    public abstract List<Vacanta> selectAll();
}
