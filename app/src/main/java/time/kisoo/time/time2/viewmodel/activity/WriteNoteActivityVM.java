package time.kisoo.time.time2.viewmodel.activity;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionMenu;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.inject.Inject;

import cn.finalteam.rxgalleryfinal.RxGalleryFinal;
import cn.finalteam.rxgalleryfinal.bean.MediaBean;
import cn.finalteam.rxgalleryfinal.imageloader.ImageLoaderType;
import cn.finalteam.rxgalleryfinal.rxbus.RxBusResultSubscriber;
import cn.finalteam.rxgalleryfinal.rxbus.event.ImageMultipleResultEvent;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import time.kisoo.time.time2.BR;
import time.kisoo.time.time2.R;
import time.kisoo.time.time2.util.MyTextUtil;
import time.kisoo.time.time2.util.ScreenPixelUtil;
import time.kisoo.time.time2.view.activity.WriteNoteActivity;

/**
 * Created by KiSoo on 2016/11/8.
 */

public class WriteNoteActivityVM extends BaseObservable {

    public WriteNoteActivity context;
    @Bindable
    private SpannableStringBuilder content;

    private int textSize;
    private int color;
    @Bindable
    private int visibility;

    @Bindable
    public String title;

    private static final int MIDDLE_TEXT_SIZE = 18;
    private static final int BIG_TEXT_SIZE = 24;
    private static final int SMALL_TEXT_SIZE = 14;

    private static final int DEFAULT_TEXT_COLOR = Color.BLACK;

    @Inject
    public WriteNoteActivityVM(WriteNoteActivity activity, SpannableStringBuilder builder) {
        this.context = activity;
        this.content = builder;
        this.textSize = MIDDLE_TEXT_SIZE;
        this.color = DEFAULT_TEXT_COLOR;
        this.visibility = View.VISIBLE;
        this.title = context.getString(R.string.new_note);
    }


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

    @Bindable
    private View.OnLongClickListener listener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            visibility = visibility == View.VISIBLE ? View.GONE : View.VISIBLE;
            notifyPropertyChanged(BR.visibility);
            notifyPropertyChanged(BR.viewModel);
            return true;
        }
    };

    @Bindable
    public View.OnLongClickListener getListener() {
        return listener;
    }

    public void setListener(View.OnLongClickListener listener) {
        this.listener = listener;
    }

    @Bindable
    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
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

    public void setContent(SpannableStringBuilder spannableString) {
        this.content = spannableString;
        notifyChange();
    }

    private void showInputMethodManager() {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
    }


    public void addPhoto(View view) {
        RxGalleryFinal.with(context)
                .image()
                .multiple()
                .imageLoader(ImageLoaderType.GLIDE)
                .maxSize(4)
                .subscribe(new RxBusResultSubscriber<ImageMultipleResultEvent>() {
                    @Override
                    protected void onEvent(ImageMultipleResultEvent resultEvent) throws Exception {
                        List<MediaBean> mediaBeanList = resultEvent.getResult();
                        addImages(mediaBeanList);
                    }
                })
                .openGallery();

    }

    /**
     * add images to editText
     *
     * @param mediaBeanList
     */
    private void addImages(List<MediaBean> mediaBeanList) {
        rx.Observable
                .from(mediaBeanList)
                .map(bean -> parsePathToSpan(bean.getOriginalPath()))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnCompleted(this::showInputMethodManager)
                .subscribe(this::displayTheImageSpan);
    }

    /**
     * show the imageSpan
     *
     * @param imageSpan
     */
    private void displayTheImageSpan(ImageSpan imageSpan) {
        int cursor = Selection.getSelectionStart(content);
        cursor = cursor == -1 ? content.length() : cursor;
        content.insert(cursor, MyTextUtil.KEY_IMAGE);
        content.setSpan(imageSpan, cursor, cursor + MyTextUtil.KEY_IMAGE.length(), Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
    }

    /**
     * get imageSpan
     *
     * @param path the path of image
     * @return the imageSpan with the bitmap(create with path)
     */
    private ImageSpan parsePathToSpan(String path) {
        Bitmap bitmap = null;
        try {
            bitmap = Glide.with(context).load(path).asBitmap().into(ScreenPixelUtil.getScreenWidth() / 3, ScreenPixelUtil.getScreenHeight() / 3).get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return new ImageSpan(context, bitmap);
    }

}
