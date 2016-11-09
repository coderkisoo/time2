package time.kisoo.time.time2.util;

/**
 * Created by KiSoo on 2016/11/3.
 */

public class MyTextUtil {
    public static final String KEY_IMAGE = "$^#@)!&&&";

    public static boolean isTitle(String content) {
        return !content.isEmpty()||isImage(content);
    }

    public static boolean isImage(String content) {
        return KEY_IMAGE.startsWith(content);
    }
}
