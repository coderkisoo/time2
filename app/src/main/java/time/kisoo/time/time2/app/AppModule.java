package time.kisoo.time.time2.app;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by KiSoo on 2016/11/7.
 */

@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Context providesApplication() {
        return app;
    }

}
