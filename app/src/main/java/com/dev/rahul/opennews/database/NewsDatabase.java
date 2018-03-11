package com.dev.rahul.opennews.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.dev.rahul.opennews.database.dao.SourceDao;
import com.dev.rahul.opennews.pojo.Sources;

/**
 * Created by rahul on 11/3/18.
 */

@Database(entities = {Sources.class}, version = 1)
public abstract class NewsDatabase extends RoomDatabase {
    public abstract SourceDao sourceDao();
}
