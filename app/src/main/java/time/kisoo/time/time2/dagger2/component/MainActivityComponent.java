package time.kisoo.time.time2.dagger2.component;

import dagger.Component;
import time.kisoo.time.time2.dagger2.module.MainActivityModule;
import time.kisoo.time.time2.view.activity.MainActivity;

/**
 * Created by KiSoo on 2016/11/7.
 */

@Component(
        dependencies = AppComponent.class,
        modules = MainActivityModule.class
)
@ScopeActivity
public interface MainActivityComponent {
    void injectActivity(MainActivity activity);
}
