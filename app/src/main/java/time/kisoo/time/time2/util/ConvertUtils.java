package time.kisoo.time.time2.util;

/**
 * Created by KiSoo on 2016/11/2.
 */

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

/**
 * 转换工具类
 */
public class ConvertUtils {

    @BindingAdapter({"addOnScrollListener"})
    public static void addOnScrollListener(RecyclerView view, RecyclerView.OnScrollListener listener) {
        if(listener!=null)
            view.addOnScrollListener(listener);
    }

}
