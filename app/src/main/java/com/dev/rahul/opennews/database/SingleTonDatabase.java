package com.dev.rahul.opennews.database;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Created by rahul on 11/3/18.
 */

public class SingleTonDatabase {

    private static SingleTonDatabase singleTonDatabase;
    private static NewsDatabase db;

    private SingleTonDatabase() {}

    public static SingleTonDatabase getInstance() {
        if (singleTonDatabase == null)
            singleTonDatabase = new SingleTonDatabase();
        return singleTonDatabase;
    }


    public NewsDatabase db(Context context) {
        if (db == null)
            db = Room.databaseBuilder(context, NewsDatabase.class, "news_api_database")
                    .build();
        return db;
    }
}
