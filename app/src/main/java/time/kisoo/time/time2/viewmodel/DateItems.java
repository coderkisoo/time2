package time.kisoo.time.time2.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;

import time.kisoo.time.time2.model.DateInfo;

/**
 * Created by KiSoo on 2016/11/1.
 */

public class DateItems extends BaseObservable {
    @Bindable
    public ObservableArrayList<DateInfo> dates;

    public DateItems(){
        this.dates = new ObservableArrayList<>();
    }

}
