package time.kisoo.time.time2.dagger2.component.fragment;

import dagger.Component;
import time.kisoo.time.time2.dagger2.component.ScopeFragment;
import time.kisoo.time.time2.dagger2.component.activity.MainActivityComponent;
import time.kisoo.time.time2.dagger2.module.fragment.SettingFragmentModule;
import time.kisoo.time.time2.view.activity.MainActivity;
import time.kisoo.time.time2.view.fragment.SettingFragment;

/**
 * Created by KiSoo on 2016/11/9.
 */

@ScopeFragment
@Component(dependencies = MainActivityComponent.class,
        modules = SettingFragmentModule.class
)
public interface SettingFragmentComponent {
    void injectFragment(SettingFragment mainFragment);
    void injectActivity(MainActivity activity);
}
