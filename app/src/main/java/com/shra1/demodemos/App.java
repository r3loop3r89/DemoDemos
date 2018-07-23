package com.shra1.demodemos;

import android.app.Application;
import android.arch.persistence.room.Room;

public class App extends Application {

    public static MyRoomDb db = null;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(this, MyRoomDb.class, "Shra1.db").build();
    }
}
