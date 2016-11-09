package time.kisoo.time.time2.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableBoolean;

/**
 * Created by KiSoo on 2016/11/1.
 */

public class DateInfo extends BaseObservable{

    private Message message;
    private ObservableBoolean hasDone;

    public DateInfo(ObservableBoolean hasDone, Message message) {
        this.message = message;
        this.hasDone = hasDone;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public ObservableBoolean isHasDone() {
        return hasDone;
    }

    public void setHasDone(ObservableBoolean hasDone) {
        this.hasDone = hasDone;
    }


}
