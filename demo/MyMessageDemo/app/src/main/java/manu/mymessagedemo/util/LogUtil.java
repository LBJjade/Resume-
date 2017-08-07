package manu.mymessagedemo.util;

import android.util.Log;

/**
 * Created by weedys on 16/7/20.
 */
public class LogUtil {

    private static boolean ishow = true;

    public static void show(String tag, String msg) {
        if (ishow) Log.i(tag, msg);
    }

    public static void show(String msg) {
        if (ishow) Log.i("weed", msg);
    }
}
