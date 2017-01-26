package time.kisoo.time.time2.app;

import android.app.Application;

import cn.bmob.v3.Bmob;
import cn.mycommons.androidsizeutil.AndroidSizeUtil;
import time.kisoo.time.time2.common.config.Constant;
import time.kisoo.time.time2.dagger2.component.AppComponent;
import time.kisoo.time.time2.dagger2.component.DaggerAppComponent;
import time.kisoo.time.time2.util.DialogUtil;
import time.kisoo.time.time2.util.SpUtil;
import time.kisoo.time.time2.util.ToastUtil;

/**
 * Created by KiSoo on 2016/11/2.
 */

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        SpUtil.init(this);
        AndroidSizeUtil.init(this);
        ToastUtil.init(this);
        DialogUtil.init(this);
        Bmob.initialize(this, Constant.BMOB_ID);
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.injectApplication(this);
    }

    public AppComponent component() {
        return appComponent;
    }
}
