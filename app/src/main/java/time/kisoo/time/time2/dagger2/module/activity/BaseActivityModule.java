package time.kisoo.time.time2.dagger2.module.activity;

import android.app.Activity;

/**
 * Created by KiSoo on 2016/11/17.
 */

public abstract class BaseActivityModule <T extends Activity>{
    public T mContext;

    public BaseActivityModule(T mContext) {
        this.mContext = mContext;
    }
}
