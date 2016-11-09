package time.kisoo.time.time2.viewmodel;

import time.kisoo.time.time2.view.base.BaseActivity;

/**
 * Created by KiSoo on 2016/11/7.
 */


public class BaseViewModel<T extends BaseActivity> {
    public T context;

    public BaseViewModel(T activity) {
        this.context = activity;
    }


    T providesActivity() {
        return context;
    }

}
