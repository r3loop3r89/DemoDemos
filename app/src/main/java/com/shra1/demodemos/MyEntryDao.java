package com.shra1.demodemos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.shra1.demodemos.dtos.MyEntry;

import java.util.List;

@Dao
public interface MyEntryDao {

    @Insert
    public void addMyEntry(MyEntry myEntry);


    @Query("Select * from MyEntry")
    public List<MyEntry> getAllMyEntries();
}
