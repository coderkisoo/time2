package time.kisoo.time.time2.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by KiSoo on 2016/11/2.
 */

public class ToastUtil {
    private static Context mContext;
    public static void init(Context context){
        mContext = context;
    }
    public static void shortMessage(String message){
        Toast.makeText(mContext,message,Toast.LENGTH_SHORT).show();
    }
    public static void longMessage(String message){
        Toast.makeText(mContext,message,Toast.LENGTH_LONG).show();
    }
}
