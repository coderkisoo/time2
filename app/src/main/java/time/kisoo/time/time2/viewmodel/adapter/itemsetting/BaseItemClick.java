package time.kisoo.time.time2.viewmodel.adapter.itemsetting;

import android.databinding.Bindable;
import android.view.View;

import time.kisoo.time.time2.common.config.Constant;
import time.kisoo.time.time2.viewmodel.adapter.BaseItemSettingVM;
import time.kisoo.time.time2.viewmodel.adapter.ClickAction;

/**
 * Created by KiSoo on 2016/11/17.
 */

public class BaseItemClick extends BaseItemSettingVM {

    @Bindable
    public int imgSrc;
    @Bindable
    public String settingInfo;
    @Bindable
    public String description;
    private ClickAction clickAction;

    public BaseItemClick(int imgSrc, String settingInfo, String description, ClickAction action) {
        this.imgSrc = imgSrc;
        this.settingInfo = settingInfo;
        this.description = description;
        this.clickAction = action;
        this.type = Constant.TYPE_CLICK;
    }

    public void clickItem(View view) {
        if (clickAction != null)
            clickAction.click(view);
    }


}
