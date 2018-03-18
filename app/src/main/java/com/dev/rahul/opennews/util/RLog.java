package com.dev.rahul.opennews.util;

import android.content.Context;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static java.lang.System.*;

/**
 * Created by rahul on 18/3/18.
 */

public class RLog {

    private static Context context;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({DEBUG, RELEASE})
    public @interface BuildTypeDef {}

    public static final int DEBUG = 0;
    public static final int RELEASE = 1;
    private static int BUILD_TYPE = 0;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({DEBUG, ERROR})
    public @interface PrintTypeDef {}

    public static final int ERROR = 1;

    private RLog() {}

    public static void init(Context context) {
        RLog.context = context;
    }

    public static void buildType(@BuildTypeDef int type) {
        BUILD_TYPE = type;
    }

    public static void print(String tag, String text, @PrintTypeDef int printType) {
        if (context == null || BUILD_TYPE == 1)
            return;

        out.println("-----------------------------------------\n");
        switch (printType) {
            case DEBUG :
                out.println("TAG = > " + isValidTagToPrint(tag) + "\n");
                out.println("TEXT = > " + isValidTextToPrint(text));
                break;
            case ERROR :
                err.print("TAG = > " + isValidTagToPrint(tag) + "\n");
                err.println("TEXT = > " + isValidTextToPrint(text));
                break;
        }
        out.println("\n-----------------------------------------");
    }

    private static String isValidTagToPrint(String tag) {
        if (tag == null)
            return "Tag is null";

        if (tag.trim().isEmpty())
            return "Tag is empty";

        return tag;
    }

    private static String isValidTextToPrint(String text) {
        if (text == null)
            return "Text is value is null";

        if (text.trim().isEmpty())
            return "Text is empty";

        return text;
    }
}
