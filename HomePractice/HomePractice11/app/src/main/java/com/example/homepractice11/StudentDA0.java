package com.example.homepractice11;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StudentDA0 {

    @Insert
    public void insertStudent(Student s);

    @Query("select * from student")
    public List<Student> selectAll();

}
