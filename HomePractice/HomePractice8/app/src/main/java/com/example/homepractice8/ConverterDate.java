package com.example.homepractice8;


import androidx.room.TypeConverter;

import java.util.Date;

public class ConverterDate {

    @TypeConverter
    public long dateToLong(Date data){
        return data.getTime();
    }

    @TypeConverter
    public Date longToDate(long data){
        return new Date(data);
    }
}
