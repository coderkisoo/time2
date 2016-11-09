package time.kisoo.time.time2.dagger2.component;

import time.kisoo.time.time2.view.fragment.MainFragment;

/**
 * Created by KiSoo on 2016/11/9.
 */

//@ScopeActivity
//@Component(dependencies = AppComponent.class,
//        modules = {MainActivityModule.class, MainFragmentModule.class}
//)
public interface MainFragmentComponent {
    void inject(MainFragment fragment);
}
