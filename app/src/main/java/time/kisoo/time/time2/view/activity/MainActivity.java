package time.kisoo.time.time2.view.activity;

import android.os.Bundle;

import javax.inject.Inject;

import time.kisoo.time.time2.R;
import time.kisoo.time.time2.app.App;
import time.kisoo.time.time2.dagger2.component.DaggerMainActivityComponent;
import time.kisoo.time.time2.dagger2.module.MainActivityModule;
import time.kisoo.time.time2.databinding.MainActivityBinding;
import time.kisoo.time.time2.view.base.BaseActivity;
import time.kisoo.time.time2.view.fragment.MainFragment;
import time.kisoo.time.time2.viewmodel.MainActivityVM;


public class MainActivity extends BaseActivity<MainActivityBinding> {

    @Inject
    MainActivityVM activityVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initToolbar();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_content, new MainFragment())
                .commitAllowingStateLoss();
    }


    @Override
    protected void initModelWithDagger2() {
        DaggerMainActivityComponent.builder()
                .appComponent(((App) getApplication()).component())
                .mainActivityModule(new MainActivityModule(this))
                .build()
                .injectActivity(this);
        binding.setViewModel(activityVM);
    }

    private void initToolbar() {
        initToolbar(binding.rlTitle.tbMain, "time2",false);
    }

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

}
