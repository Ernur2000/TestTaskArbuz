package com.bolatovyernur.testtaskarbuz.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "info_table")
public class Info {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "place")
    public String place;

    @ColumnInfo(name = "weight")
    public String weight;

    @ColumnInfo(name = "state")
    public String state;

    @ColumnInfo(name = "count")
    public String count;

    @ColumnInfo(name = "city")
    public String city;

    @ColumnInfo(name = "street")
    public String street;

    @ColumnInfo(name = "flat")
    public String flat;

    @ColumnInfo(name = "floor")
    public String floor;

    @ColumnInfo(name = "date")
    public String date;

    @ColumnInfo(name = "time")
    public String time;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "comment")
    public String comment;

    @ColumnInfo(name = "cutIntoSlices")
    public boolean cutIntoSlices;

    public Info(int id, String place, String weight, String state, String count, String city, String street, String flat, String floor, String date, String time, String name, String comment, boolean cutIntoSlices) {
        this.id = id;
        this.place = place;
        this.weight = weight;
        this.state = state;
        this.count = count;
        this.city = city;
        this.street = street;
        this.flat = flat;
        this.floor = floor;
        this.date = date;
        this.time = time;
        this.name = name;
        this.comment = comment;
        this.cutIntoSlices = cutIntoSlices;
    }
}
