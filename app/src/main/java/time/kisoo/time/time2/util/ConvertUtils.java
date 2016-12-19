package time.kisoo.time.time2.util;

/**
 * Created by KiSoo on 2016/11/2.
 */

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

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
}
