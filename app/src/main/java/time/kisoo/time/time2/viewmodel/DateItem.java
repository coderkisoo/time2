package time.kisoo.time.time2.viewmodel;

import android.databinding.BaseObservable;

import time.kisoo.time.time2.model.DateInfo;

/**
 * Created by KiSoo on 2016/11/1.
 */

public class DateItem extends BaseObservable {
    private DateInfo info;


    public DateItem(DateInfo info) {
        this.info = info;
    }

    public DateInfo getInfo() {
        return info;
    }

    public void setInfo(DateInfo info) {
        this.info = info;
    }

}
