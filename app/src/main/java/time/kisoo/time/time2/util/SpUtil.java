package time.kisoo.time.time2.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by KiSoo on 2016/11/2.
 */

/**
 * SpUtil
 */
public final class SpUtil {
    private static SharedPreferences sp;
    private static final String SP_NAME = "time2_sp";

    public static void init(Context context) {
        sp = context.getSharedPreferences(SP_NAME, Context.MODE_APPEND);
    }

    public static void putBoolean(String key, boolean value) {
        sp.edit().putBoolean(key,value).apply();
    }

    public static void putString(String key,String value){
        sp.edit().putString(key,value).apply();
    }

    public static void putByte(String key,int value){
        sp.edit().putInt(key,value).apply();
    }


}
