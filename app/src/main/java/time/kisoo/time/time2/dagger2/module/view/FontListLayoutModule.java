package time.kisoo.time.time2.dagger2.module.view;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import time.kisoo.time.time2.dagger2.module.activity.BaseActivityModule;
import time.kisoo.time.time2.view.activity.FontSettingActivity;
import time.kisoo.time.time2.viewmodel.view.FontListLayoutVM;

/**
 * Created by kangqizhou on 2017/1/23.
 */


@Module
public class FontListLayoutModule extends BaseActivityModule<FontSettingActivity> {


    public FontListLayoutModule(FontSettingActivity mContext) {
        super(mContext);
    }

    @Provides
    Context getContext() {
        return mContext;
    }

    @Provides
    FontListLayoutVM provideViewModel() {
        return new FontListLayoutVM(mContext);
    }

}
