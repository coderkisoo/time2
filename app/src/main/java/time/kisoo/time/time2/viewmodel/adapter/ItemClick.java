package time.kisoo.time.time2.viewmodel.adapter;

import android.databinding.Bindable;
import android.view.View;

import time.kisoo.time.time2.view.adapter.SettingAdapter;

/**
 * Created by KiSoo on 2016/11/17.
 */

public class ItemClick extends ItemSettingVM {

    @Bindable
    public int imgSrc;
    @Bindable
    public String settingInfo;
    @Bindable
    public String description;
    private ClickAction clickAction;

    public ItemClick(int imgSrc, String settingInfo, String description, ClickAction action) {
        this.imgSrc = imgSrc;
        this.settingInfo = settingInfo;
        this.description = description;
        this.clickAction = action;
        this.type = SettingAdapter.TYPE_CLICK;
    }

    public void clickItem(View view) {
        if (clickAction != null)
            clickAction.click(view);
    }


}
