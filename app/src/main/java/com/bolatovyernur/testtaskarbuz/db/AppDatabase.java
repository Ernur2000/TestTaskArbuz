package com.bolatovyernur.testtaskarbuz.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Info.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract InfoDao infoDao();

    private static AppDatabase INSTANCE;

    public static synchronized AppDatabase getDbInstance(Context context){
        if (INSTANCE==null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"info_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
