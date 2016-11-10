package time.kisoo.time.time2.view.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by KiSoo on 2016/11/2.
 */

public abstract class BaseFragment<T extends ViewDataBinding> extends Fragment{
    public T binding;
    public Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, layoutId(),container,false);
        bindView();
        return binding.getRoot();
    }

    protected abstract void bindView();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        initModelWithDagger2();
    }

    protected abstract void initModelWithDagger2();

    protected abstract int layoutId();
}
