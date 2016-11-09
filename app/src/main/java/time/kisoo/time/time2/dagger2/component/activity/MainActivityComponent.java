package time.kisoo.time.time2.dagger2.component.activity;

import dagger.Component;
import time.kisoo.time.time2.dagger2.component.AppComponent;
import time.kisoo.time.time2.dagger2.component.ScopeActivity;
import time.kisoo.time.time2.dagger2.module.activity.MainActivityModule;
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
