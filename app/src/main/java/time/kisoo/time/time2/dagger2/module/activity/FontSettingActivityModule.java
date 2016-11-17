package time.kisoo.time.time2.dagger2.module.activity;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import time.kisoo.time.time2.view.activity.FontSettingActivity;
import time.kisoo.time.time2.viewmodel.activity.FontSettingActivityVM;

/**
 * Created by KiSoo on 2016/11/17.
 */

@Module
public class FontSettingActivityModule extends BaseActivityModule<FontSettingActivity> {


    public FontSettingActivityModule(FontSettingActivity mContext) {
        super(mContext);
    }

    @Provides
    Context getContext() {
        return mContext;
    }

    @Provides
    FontSettingActivityVM provideViewModel() {
        return new FontSettingActivityVM(mContext);
    }

}
