package time.kisoo.time.time2.viewmodel.fragment;

import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import javax.inject.Inject;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.util.ToastUtil;
import time.kisoo.time.time2.view.activity.MainActivity;
import time.kisoo.time.time2.view.adapter.SettingAdapter;
import time.kisoo.time.time2.view.fragment.SettingFragment;
import time.kisoo.time.time2.viewmodel.BaseViewModel;
import time.kisoo.time.time2.viewmodel.adapter.ItemClick;
import time.kisoo.time.time2.viewmodel.adapter.ItemEmpty;
import time.kisoo.time.time2.viewmodel.adapter.ItemSettingVM;
import time.kisoo.time.time2.viewmodel.adapter.ItemSlide;

/**
 * Created by KiSoo on 2016/11/10.
 */

public class SettingFragmentVM extends BaseViewModel {
    private MainActivity mContext;
    private SettingFragment mFragment;
    @Bindable
    public SettingAdapter adapter;
    private ArrayList<ItemSettingVM> mList;
    @Bindable
    public RecyclerView.LayoutManager manager;

    @Inject
    public SettingFragmentVM(MainActivity context, SettingFragment fragment) {
        this.mContext = context;
        this.mFragment = fragment;
        initSettingItem();
        this.adapter = new SettingAdapter(mList);
        this.manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
    }

    private void initSettingItem() {
        this.mList = new ArrayList<>();
        mList.add(new ItemEmpty(16));
        mList.add(
                new ItemSlide(R.mipmap.icon_update,
                        mContext.getString(R.string.item_update),
                        mContext.getString(R.string.description_update),
                        true));
        mList.add(new ItemEmpty(32));
        mList.add(new ItemClick(
                R.mipmap.ic_launcher,
                "设置2",
                mContext.getString(R.string.description_update),
                view -> ToastUtil.shortMessage(view.getAccessibilityClassName().toString())));
    }


}
