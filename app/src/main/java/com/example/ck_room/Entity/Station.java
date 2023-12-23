package com.example.ck_room.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "station")
public class Station {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "station_id")
    private int stationId;
    private String name;
    private String address;
    public Station( String name, String address) {
        this.name = name;
        this.address = address;
    }public Station()
    {
    }
    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Station{" +
                "stationId=" + stationId +
                ", name='" + name + '\'' +
                '}';
    }
}