package time.kisoo.time.time2.viewmodel.activity;

import android.content.Context;
import android.databinding.Bindable;

import javax.inject.Inject;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.view.activity.FontSettingActivity;
import time.kisoo.time.time2.viewmodel.BaseViewModel;

/**
 * Created by KiSoo on 2016/11/8.
 */

public class FontSettingActivityVM extends BaseViewModel {

    private FontSettingActivity context;

    @Bindable
    public String title;

    @Inject
    public FontSettingActivityVM(Context context) {
        this.context = (FontSettingActivity) context;
        this.title = context.getString(R.string.item_font);
    }


}
