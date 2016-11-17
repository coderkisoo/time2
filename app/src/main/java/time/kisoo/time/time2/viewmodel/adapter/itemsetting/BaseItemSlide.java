package time.kisoo.time.time2.viewmodel.adapter.itemsetting;

import android.databinding.Bindable;
import android.support.annotation.DrawableRes;
import android.view.View;

import time.kisoo.time.time2.common.config.Constant;
import time.kisoo.time.time2.util.SpUtil;
import time.kisoo.time.time2.viewmodel.adapter.BaseItemSettingVM;

/**
 * Created by KiSoo on 2016/11/17.
 */

public class BaseItemSlide extends BaseItemSettingVM {

    @Bindable
    public boolean switchAble = false;

    @Bindable
    public int imgSrc;
    @Bindable
    public String settingInfo;
    @Bindable
    public String description;

    private String key;

    public BaseItemSlide(@DrawableRes int imgSrc, String settingInfo, String description, String key) {
        this.imgSrc = imgSrc;
        this.settingInfo = settingInfo;
        this.description = description;
        this.type = Constant.TYPE_SLIDE;
        this.key = key;
        this.switchAble = SpUtil.getBoolean(key,true);
    }

    public void clickItem(View view) {
        switchAble = !switchAble;
        SpUtil.putBoolean(key,switchAble);
        notifyChange();
    }

}
