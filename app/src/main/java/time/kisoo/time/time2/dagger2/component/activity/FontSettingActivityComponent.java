package time.kisoo.time.time2.dagger2.component.activity;

import dagger.Component;
import time.kisoo.time.time2.dagger2.component.AppComponent;
import time.kisoo.time.time2.dagger2.component.ScopeActivity;
import time.kisoo.time.time2.dagger2.module.activity.FontSettingActivityModule;
import time.kisoo.time.time2.dagger2.module.view.FontListLayoutModule;
import time.kisoo.time.time2.view.activity.FontSettingActivity;

/**
 * Created by KiSoo on 2016/11/8.
 */

@Component(
        dependencies = AppComponent.class,
        modules = {FontSettingActivityModule.class, FontListLayoutModule.class}
)
@ScopeActivity
public interface FontSettingActivityComponent {
    void inject(FontSettingActivity activity);
}
