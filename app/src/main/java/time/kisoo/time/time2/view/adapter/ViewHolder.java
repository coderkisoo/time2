package time.kisoo.time.time2.view.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by KiSoo on 2016/11/17.
 */
public class ViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    public T binding;

    public ViewHolder(T t) {
        super(t.getRoot());
        this.binding = t;
    }


    public static <T extends ViewDataBinding> ViewHolder getInstance(ViewGroup parent, int layoutId) {
        return new ViewHolder<T>(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), layoutId, parent, false));
    }

}
