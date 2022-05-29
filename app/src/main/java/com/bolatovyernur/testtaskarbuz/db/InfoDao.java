package com.bolatovyernur.testtaskarbuz.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import java.util.List;

@Dao
public interface InfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertInfo(List<Info> info);
}
