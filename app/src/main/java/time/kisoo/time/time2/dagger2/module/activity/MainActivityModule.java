package time.kisoo.time.time2.dagger2.module.activity;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import time.kisoo.time.time2.view.activity.MainActivity;
import time.kisoo.time.time2.viewmodel.activity.MainActivityVM;

/**
 * Created by KiSoo on 2016/11/8.
 */

@Module
public class MainActivityModule extends BaseActivityModule<MainActivity>{

    public MainActivityModule(MainActivity context) {
        super(context);
    }

    @Provides
    Context provideContext() {
        return mContext;
    }

    @Provides
    MainActivityVM provideViewModel() {
        return new MainActivityVM(mContext);
    }


}