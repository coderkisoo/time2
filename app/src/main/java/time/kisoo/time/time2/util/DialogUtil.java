package time.kisoo.time.time2.util;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.app.App;

/**
 * Created by KiSoo on 2017/1/24.
 */

public class DialogUtil {
    private static App mContext;

    public static void init(App context){
        mContext = context;
    }

    public static AlertDialog showDialog(String title,String message,DialogInterface.OnClickListener cancelListener,DialogInterface.OnClickListener confirmListener){
        return new AlertDialog.Builder(mContext.getCurrentActivity())
                .setTitle(title)
                .setMessage(message)
                .setNegativeButton(mContext.getResources().getText(R.string.cancel), cancelListener)
                .setPositiveButton(mContext.getResources().getText(R.string.confirm),confirmListener)
                .show();
    }
}
