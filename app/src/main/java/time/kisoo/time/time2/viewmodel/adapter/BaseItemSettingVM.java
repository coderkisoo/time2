package time.kisoo.time.time2.viewmodel.adapter;

import android.databinding.Bindable;

import time.kisoo.time.time2.common.config.Constant;
import time.kisoo.time.time2.viewmodel.BaseViewModel;

/**
 * Created by KiSoo on 2016/11/10.
 */

public class BaseItemSettingVM extends BaseViewModel {
    @Bindable
    public int type = Constant.TYPE_CLICK;

}
