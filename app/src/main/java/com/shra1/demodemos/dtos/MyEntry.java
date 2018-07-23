package com.shra1.demodemos.dtos;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class MyEntry {
    long savedOnEpoch;
    @PrimaryKey(autoGenerate = true)
    private int id;

    public MyEntry(long savedOnEpoch) {

        this.savedOnEpoch = savedOnEpoch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSavedOnEpoch() {
        return savedOnEpoch;
    }

    public void setSavedOnEpoch(long savedOnEpoch) {
        this.savedOnEpoch = savedOnEpoch;
    }
}
