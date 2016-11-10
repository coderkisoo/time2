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
public class MainActivityModule {
    private MainActivity context;

    public MainActivityModule(MainActivity context) {
        this.context = context;
    }

    @Provides
    Context provideContext() {
        return context;
    }

    @Provides
    MainActivityVM provideViewModel() {
        return new MainActivityVM(context);
    }


}