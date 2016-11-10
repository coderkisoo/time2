package time.kisoo.time.time2.dagger2.module.fragment;

import dagger.Module;
import dagger.Provides;
import time.kisoo.time.time2.view.activity.MainActivity;
import time.kisoo.time.time2.view.fragment.SettingFragment;
import time.kisoo.time.time2.viewmodel.fragment.SettingFragmentVM;

/**
 * Created by KiSoo on 2016/11/10.
 */

@Module
public class SettingFragmentModule extends BaseFragmentModule<MainActivity, SettingFragment> {

    public SettingFragmentModule(MainActivity context, SettingFragment fragment) {
        super(context, fragment);
    }

    @Provides
    MainActivity provideMainActivity() {
        return this.context;
    }

    @Provides
    SettingFragment provideSettingFragment() {
        return this.fragment;
    }

    @Provides
    SettingFragmentVM provideViewModel() {
        return new SettingFragmentVM(context, fragment);
    }
}
