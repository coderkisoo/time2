package time.kisoo.time.time2.dagger2.component;

import javax.inject.Singleton;

import dagger.Component;
import time.kisoo.time.time2.app.AppModule;
import time.kisoo.time.time2.app.App;

/**
 * Created by KiSoo on 2016/11/8.
 */
@Singleton
@Component(
        modules = AppModule.class
)
public interface AppComponent {
    void injectApplication(App app);
}
