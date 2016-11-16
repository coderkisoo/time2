package time.kisoo.time.time2.viewmodel.adapter;

import android.databinding.Bindable;

import time.kisoo.time.time2.util.ScreenPixelUtil;
import time.kisoo.time.time2.view.adapter.SettingAdapter;

/**
 * Created by KiSoo on 2016/11/17.
 */

public class ItemEmpty extends ItemSettingVM{

    @Bindable
    public int height = 0;

    public ItemEmpty(int height) {
        this.height = ScreenPixelUtil.getInstance().dp(height);
        this.type = SettingAdapter.TYPE_EMPTY;
    }


}
