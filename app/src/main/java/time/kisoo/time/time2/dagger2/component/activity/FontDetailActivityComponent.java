package time.kisoo.time.time2.dagger2.component.activity;

import dagger.Component;
import time.kisoo.time.time2.dagger2.component.AppComponent;
import time.kisoo.time.time2.dagger2.component.ScopeActivity;
import time.kisoo.time.time2.dagger2.module.activity.FontDetailActivityModule;
import time.kisoo.time.time2.view.activity.FontDetailActivity;

/**
 * Created by KiSoo on 2017/1/24.
 */

@Component(
        dependencies = AppComponent.class,
        modules = {FontDetailActivityModule.class}
)
@ScopeActivity
public interface FontDetailActivityComponent {
    void inject(FontDetailActivity context);
}
