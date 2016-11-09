package time.kisoo.time.time2.model;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;

/**
 * Created by KiSoo on 2016/11/1.
 */

public class Message extends BaseObservable {
    private String title;//标题
    private String message;//正文
    private ObservableArrayList<String> imges;//图片

    public Message(String title, String message, ObservableArrayList<String> imges) {
        this.title = title;
        this.message = message;
        this.imges = imges;
    }

    public ObservableArrayList<String> getImges() {
        return imges;
    }

    public void setImges(ObservableArrayList<String> imges) {
        this.imges = imges;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



}
