package time.kisoo.time.time2.viewmodel.adapter.itemsetting;

import android.databinding.Bindable;

import time.kisoo.time.time2.common.config.Constant;
import time.kisoo.time.time2.util.ScreenPixelUtil;
import time.kisoo.time.time2.viewmodel.adapter.BaseItemSettingVM;

/**
 * Created by KiSoo on 2016/11/17.
 */

public class BaseItemEmpty extends BaseItemSettingVM {

    @Bindable
    public int height = 0;

    public BaseItemEmpty(int height) {
        this.height = ScreenPixelUtil.getInstance().dp(height);
        this.type = Constant.TYPE_EMPTY;
    }


}
