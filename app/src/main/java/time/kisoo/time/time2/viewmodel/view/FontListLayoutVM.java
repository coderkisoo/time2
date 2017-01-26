package time.kisoo.time.time2.viewmodel.view;

import android.content.Context;
import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import time.kisoo.time.time2.view.adapter.FontSettingAdapter;
import time.kisoo.time.time2.viewmodel.BaseViewModel;
import time.kisoo.time.time2.viewmodel.adapter.BaseItemSettingVM;

/**
 * Created by kangqizhou on 2017/1/23.
 */

public class FontListLayoutVM extends BaseViewModel {

    @Bindable
    public FontSettingAdapter adapter;

    @Bindable
    public RecyclerView.LayoutManager manager;

    private List<BaseItemSettingVM> list;
    public FontListLayoutVM(Context context) {
        this.list = new ArrayList<>();
        this.adapter = new FontSettingAdapter(list);
        this.manager = new LinearLayoutManager(context);
    }

}
