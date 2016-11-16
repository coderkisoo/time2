package time.kisoo.time.time2.viewmodel.adapter;

import android.databinding.Bindable;
import android.support.annotation.DrawableRes;
import android.view.View;

import time.kisoo.time.time2.view.adapter.SettingAdapter;

/**
 * Created by KiSoo on 2016/11/17.
 */

public class ItemSlide extends ItemSettingVM {

    @Bindable
    public boolean switchAble = false;

    @Bindable
    public int imgSrc;
    @Bindable
    public String settingInfo;
    @Bindable
    public String description;


    public ItemSlide(@DrawableRes int imgSrc, String settingInfo, String description, boolean switchAble) {
        this.imgSrc = imgSrc;
        this.settingInfo = settingInfo;
        this.description = description;
        this.switchAble = switchAble;
        this.type = SettingAdapter.TYPE_SLIDE;
    }

    public void clickItem(View view) {
        switchAble = !switchAble;
        notifyChange();
    }

}
