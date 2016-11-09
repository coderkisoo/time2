package time.kisoo.time.time2.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.view.View;

import com.github.clans.fab.FloatingActionMenu;


/**
 * Created by KiSoo on 2016/11/4.
 */
public class NoteBody extends BaseObservable {

    /**
     * 笔记当前的实体类
     */
    @Bindable
    private SpannableStringBuilder content;
    private int textSize;
    private int color;

    private static final int MIDDLE_TEXT_SIZE = 24;
    private static final int BIG_TEXT_SIZE = 32;
    private static final int SMALL_TEXT_SIZE = 16;

    private static final int DEFAULT_TEXT_COLOR = Color.BLACK;

    @Bindable
    public SpannableStringBuilder getContent() {
        return content;
    }

    public int getTextSize() {
        return textSize;
    }

    public void setTextSize(int textSize, View view) {
        this.textSize = textSize;
        FloatingActionMenu menu = (FloatingActionMenu) view.getParent();
        menu.close(true);
        notifyChange();
    }

    public void setTextSizeBig(View view) {
        setTextSize(BIG_TEXT_SIZE, view);
    }

    public void setTextSizeSmall(View view) {
        setTextSize(SMALL_TEXT_SIZE, view);
    }

    public void setTextSizeMiddle(View view) {
        setTextSize(MIDDLE_TEXT_SIZE, view);
    }

    public int getColor() {
        return color;
    }

    private void setColor(int color, View view) {
        this.color = color;
        FloatingActionMenu menu = (FloatingActionMenu) view.getParent();
        menu.close(true);
        notifyChange();
    }

    public void setBlack(View view) {
        setColor(Color.BLACK, view);
    }

    public void setBlue(View view) {
        setColor(Color.BLUE, view);
    }

    public void setRed(View view) {
        setColor(Color.RED, view);
    }

    public NoteBody(SpannableStringBuilder content) {
        this.content = content;
    }

    public NoteBody() {
        this.content = new SpannableStringBuilder("");
        this.textSize = MIDDLE_TEXT_SIZE;
        this.color = DEFAULT_TEXT_COLOR;
    }

    public void setContent(SpannableStringBuilder spannableString) {
        this.content = spannableString;
        notifyChange();
    }


}
