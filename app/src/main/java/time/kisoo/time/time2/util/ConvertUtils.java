package time.kisoo.time.time2.util;

/**
 * Created by KiSoo on 2016/11/2.
 */

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.adapters.ListenerUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kisoo.downloadview.DownloadView;

import java.util.concurrent.ExecutionException;

import cn.bmob.v3.datatype.BmobFile;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import time.kisoo.time.time2.R;


/**
 * 转换工具类
 */
public final class ConvertUtils {

    @BindingAdapter({"addOnScrollListener"})
    public static void addOnScrollListener(RecyclerView view, RecyclerView.OnScrollListener listener) {
        if (listener != null)
            view.addOnScrollListener(listener);
    }

    @BindingAdapter({"imgSrc"})
    public static void loadImage(ImageView view, int imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

    @BindingAdapter({"imgUrl"})
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    @BindingAdapter({"panel"})
    public static void loadPanel(DownloadView view, BmobFile sample) {
        Observable
                .create(new Observable.OnSubscribe<BmobFile>() {
                    @Override
                    public void call(Subscriber<? super BmobFile> subscriber) {
                        subscriber.onNext(sample);
                    }
                })
                .map(bmobFile -> {
                    try {
                        return Glide.with(view.getContext()).load(sample.getUrl()).asBitmap().into(view.getPanelWidth(), view.getPanelHeight()).get();
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(view::setPanelSrc);

    }


    @InverseBindingAdapter(attribute = "refreshing", event = "refreshingAttrChanged")
    public static boolean isRefreshing(SwipeRefreshLayout view) {
        return view.isRefreshing();
    }

    @BindingAdapter("refreshing")
    public static void setRefreshing(SwipeRefreshLayout view, boolean refreshing) {
        if (refreshing != view.isRefreshing()) {
            view.setRefreshing(refreshing);
        }
    }

    @BindingAdapter(value = {"onRefreshListener", "refreshingAttrChanged"}, requireAll = false)
    public static void setOnRefreshListener(final SwipeRefreshLayout view,
                                            final SwipeRefreshLayout.OnRefreshListener listener,
                                            final InverseBindingListener refreshingAttrChanged) {

        SwipeRefreshLayout.OnRefreshListener newValue = () -> {
            if (listener != null) {
                if (refreshingAttrChanged != null) {
                    refreshingAttrChanged.onChange();
                }
                listener.onRefresh();
            }
        };

        SwipeRefreshLayout.OnRefreshListener oldValue = ListenerUtil.trackListener(view, newValue, R.id.onRefreshListener);
        if (oldValue != null) {
            view.setOnRefreshListener(null);
        }
        view.setOnRefreshListener(newValue);
    }

}
