package com.shra1.demodemos;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.shra1.demodemos.dtos.MyEntry;

@Database(entities = {MyEntry.class}, version = 1)
abstract class MyRoomDb extends RoomDatabase{
    public abstract MyEntryDao myEntryDao();
}
