package time.kisoo.time.time2.util;

/**
 * 自定义日志：带开关
 *
 * @author carmack
 *
 */
public final class Log {

    private final static boolean DEBUG = true;

    public static void i(String key, String value) {
        if (DEBUG) {
            android.util.Log.i(key, value);
        }

    }

    public static void e(String key, String value) {
        if (DEBUG) {
            android.util.Log.e(key, value);
        }

    }

    public static void d(String key, String value) {
        if (DEBUG) {
            android.util.Log.d(key, value);
        }

    }

    /**
     * 记录到System.out里去
     * @param log 日志记录
     */
    public static void log(String log) {
        if (DEBUG) {
            android.util.Log.d("System.out", log);
        }
    }
}