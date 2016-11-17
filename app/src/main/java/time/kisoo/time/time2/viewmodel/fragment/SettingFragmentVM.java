package time.kisoo.time.time2.viewmodel.fragment;

import android.content.Intent;
import android.databinding.Bindable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import javax.inject.Inject;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.common.config.Constant;
import time.kisoo.time.time2.util.SpUtil;
import time.kisoo.time.time2.view.activity.FontSettingActivity;
import time.kisoo.time.time2.view.activity.MainActivity;
import time.kisoo.time.time2.view.adapter.SettingAdapter;
import time.kisoo.time.time2.view.fragment.SettingFragment;
import time.kisoo.time.time2.viewmodel.BaseViewModel;
import time.kisoo.time.time2.viewmodel.adapter.BaseItemSettingVM;
import time.kisoo.time.time2.viewmodel.adapter.itemsetting.BaseItemClick;
import time.kisoo.time.time2.viewmodel.adapter.itemsetting.BaseItemEmpty;
import time.kisoo.time.time2.viewmodel.adapter.itemsetting.BaseItemSlide;

/**
 * Created by KiSoo on 2016/11/10.
 */

public class SettingFragmentVM extends BaseViewModel {
    private MainActivity mContext;
    private SettingFragment mFragment;
    @Bindable
    public SettingAdapter adapter;
    private ArrayList<BaseItemSettingVM> mList;
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
        mList.add(new BaseItemEmpty(16));
        mList.add(
                new BaseItemSlide(R.mipmap.icon_update,
                        mContext.getString(R.string.item_update),
                        mContext.getString(R.string.description_update),
                        Constant.KEY_SETTING_UPDATE));
        mList.add(new BaseItemEmpty(32));
        mList.add(new BaseItemClick(
                R.mipmap.icon_font,
                mContext.getString(R.string.item_font),
                SpUtil.getString(Constant.KEY_SETTING_FONT, mContext.getString(R.string.description_default_font)),
                this::setFont));
    }

    /**
     * 跳转到设置字体页面
     * @param view
     */
    private void setFont(View view) {
        Intent intent = new Intent(mContext, FontSettingActivity.class);
        mFragment.startActivityForResult(intent, Constant.CODE_REQUEST_FONT);
    }


}
