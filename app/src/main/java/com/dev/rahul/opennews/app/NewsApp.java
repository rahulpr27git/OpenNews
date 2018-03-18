package com.dev.rahul.opennews.app;

import android.app.Application;
import android.content.Context;

import com.dev.rahul.opennews.database.NewsDatabase;
import com.dev.rahul.opennews.database.SingleTonDatabase;
import com.dev.rahul.opennews.util.RLog;

/**
 * Created by rahul on 4/3/18.
 */

public class NewsApp extends Application {

    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        RLog.init(context);
        RLog.buildType(RLog.DEBUG);
    }

    public static NewsDatabase getDb() {
        return SingleTonDatabase.getInstance()
                .db(getContext());
    }

    public static Context getContext() {
        return context;
    }
}
