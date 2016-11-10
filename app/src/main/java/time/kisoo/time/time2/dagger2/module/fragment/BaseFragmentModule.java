package time.kisoo.time.time2.dagger2.module.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by KiSoo on 2016/11/10.
 */

public abstract class BaseFragmentModule<A extends Context, F extends Fragment> {
    public A context;
    public F fragment;

    public BaseFragmentModule(A context, F fragment) {
        this.context = context;
        this.fragment = fragment;
    }


}
